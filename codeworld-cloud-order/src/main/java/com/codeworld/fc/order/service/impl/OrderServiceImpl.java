package com.codeworld.fc.order.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.DeliveryEnum;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.DeliveryNumberUtil;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.IdWorker;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.order.client.CartClient;
import com.codeworld.fc.order.client.MemberClient;
import com.codeworld.fc.order.client.MerchantClient;
import com.codeworld.fc.order.domain.*;
import com.codeworld.fc.order.entity.Order;
import com.codeworld.fc.order.entity.OrderDetail;
import com.codeworld.fc.order.entity.OrderReturn;
import com.codeworld.fc.order.entity.OrderStatus;
import com.codeworld.fc.order.interceptor.AuthInterceptor;
import com.codeworld.fc.order.mapper.OrderDetailMapper;
import com.codeworld.fc.order.mapper.OrderMapper;
import com.codeworld.fc.order.mapper.OrderReturnMapper;
import com.codeworld.fc.order.mapper.OrderStatusMapper;
import com.codeworld.fc.order.request.OrderAddRequest;
import com.codeworld.fc.order.request.OrderSearchRequest;
import com.codeworld.fc.order.request.PayOrderRequest;
import com.codeworld.fc.order.response.OrderDetailResponse;
import com.codeworld.fc.order.response.OrderPageResponse;
import com.codeworld.fc.order.response.OrderResponse;
import com.codeworld.fc.order.response.OrderStatusCount;
import com.codeworld.fc.order.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName OrderServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired(required = false)
    private MemberClient memberClient;
    @Autowired(required = false)
    private MerchantClient merchantClient;
    @Autowired(required = false)
    private CartClient cartClient;

    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired(required = false)
    private OrderStatusMapper orderStatusMapper;
    @Autowired(required = false)
    private OrderDetailMapper orderDetailMapper;
    @Autowired(required = false)
    private OrderReturnMapper orderReturnMapper;

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    private AmqpTemplate amqpTemplate;

    @Autowired(required = false)
    private IdWorker idWorker;

    /**
     * 创建订单
     *
     * @param orderAddRequest
     * @return
     */
    @Override
    @Transactional
    public FCResponse<String> createOrder(OrderAddRequest orderAddRequest) {
        Order order = new Order();
        order.setId(idWorker.nextId());
        order.setMemberId(orderAddRequest.getMemberId());
        order.setTotalPay(orderAddRequest.getPayTotal());
        // 根据会员id查询会员信息
        FCResponse<MemberInfo> memberResponse = this.memberClient.getMemberById(orderAddRequest.getMemberId());
        if (!memberResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.member.MEMBER_DATA_EXPIRE.getMsg());
        }
        MemberInfo memberInfo = memberResponse.getData();
        order.setBuyerName(memberInfo.getMemberName());
        order.setAddressId(orderAddRequest.getAddressId());
        order.setCreateTime(new Date());
        // 创建订单
        this.orderMapper.createOrder(order);

        // 保存订单状态
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(order.getId());
        orderStatus.setCreateTime(order.getCreateTime());
        // 默认为未支付状态
        orderStatus.setOrderStatus(1);
        this.orderStatusMapper.saveOrderStatus(orderStatus);
        // 将Json装换位List对象
        List<ProductInfoSkuModel> productInfoSkuModels = JsonUtils.parseList(orderAddRequest.getProductInfoSkuModels(), ProductInfoSkuModel.class);

        // 循环添加订单详细
        assert productInfoSkuModels != null;
        productInfoSkuModels.forEach(productInfoSkuModel -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setDetailId(IDGeneratorUtil.getNextId());
            orderDetail.setCreateTime(order.getCreateTime());
            orderDetail.setProductCount(productInfoSkuModel.getProductCount());
            orderDetail.setProductImage(productInfoSkuModel.getProductImage());
            orderDetail.setProductPrice(productInfoSkuModel.getPrice());
            orderDetail.setProductSkuId(productInfoSkuModel.getId());
            orderDetail.setProductTitle(productInfoSkuModel.getProductTitle());
            // 创建SkuModel
            ProductSkuModel productSkuModel = new ProductSkuModel();
            productSkuModel.setId(productInfoSkuModel.getId());
            productSkuModel.setImages(productInfoSkuModel.getImages());
            productSkuModel.setPrice(productInfoSkuModel.getPrice());
            productSkuModel.setTitle(productInfoSkuModel.getTitle());
            // 将其序列化
            String skuDetail = JsonUtils.serialize(productSkuModel);
            orderDetail.setProductSkuDetail(skuDetail);
            orderDetail.setMerchantNumber(productInfoSkuModel.getMerchantNumber());
            // 添加订单明细
            this.orderDetailMapper.saveOrderDetail(orderDetail);
        });
        log.info("生成订单，订单编号：{}，用户id：{}", order.getId(), memberInfo.getMemberId());
        // 将订单信息保存到redis缓存中,时间为10分钟，10分钟过后将其置为失效订单
        // 将订单id作为Key，订单信息作为value
        Map<String, Object> map = new HashMap<>(2);
        map.put("orderId", order.getId());
        map.put("totalPay", order.getTotalPay());
        // 将map进行序列化
        String json = JsonUtils.serialize(map);
        assert json != null;
        this.stringRedisTemplate.opsForValue().set(String.valueOf(order.getId()), json, 60 * 10, TimeUnit.SECONDS);
        log.info("订单加入Redis缓存，订单编号：{}，用户id：{}，将在10分钟后过期", order.getId(), memberInfo.getMemberId());
        // 异步删除购物车中对应的数据（使用RabbitMQ消息队列）
        this.amqpTemplate.convertAndSend("cart.delete", orderAddRequest.getCartIds());
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_CREATE_SUCCESS.getMsg(), String.valueOf(order.getId()));
    }

    /**
     * 分页查询当前用户订单信息
     *
     * @param orderSearchRequest
     * @return
     */
    @Override
    public FCResponse<List<OrderResponse>> getPageMemberOrder(OrderSearchRequest orderSearchRequest) {
        PageHelper.startPage(orderSearchRequest.getPage(), orderSearchRequest.getLimit());
        // 获取当前登录用户
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        // 根据用户id查询订单基本信息
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", loginInfoData.getId());
        map.put("orderStatus", orderSearchRequest.getOrderStatus());
        List<OrderResponse> orderResponses = this.orderMapper.getPageMemberOrder(map);
        if (CollectionUtils.isEmpty(orderResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        PageInfo<OrderResponse> pageInfo = new PageInfo<>(orderResponses);
        AtomicReference<Integer> count = new AtomicReference<>(0);
        // 循环查询订单下的商品信息
        pageInfo.getList().forEach(orderResponse -> {
            // 根据订单编号查询订单下的商品详细信息
            List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderId(orderResponse.getOrderId());
            if (CollectionUtils.isEmpty(orderDetails)) {
                log.error("该订单号下无商品信息");
                throw new FCException("系统异常");
            }
            List<ProductModel> productModels = new ArrayList<>();
            orderDetails.forEach(orderDetail -> {
                ProductModel productModel = new ProductModel();
                ProductSkuModel productSkuModel = new ProductSkuModel();
                // 设置商品信息
                productModel.setProductCount(orderDetail.getProductCount());
                productModel.setProductImage(orderDetail.getProductImage());
                productModel.setProductTitle(orderDetail.getProductTitle());
                // 设置sku信息
                productSkuModel = JsonUtils.parse(orderDetail.getProductSkuDetail(), ProductSkuModel.class);
                productModel.setProductSkuModel(productSkuModel);
                productModels.add(productModel);
                count.updateAndGet(v -> v + orderDetail.getProductCount());
            });
            orderResponse.setProductModels(productModels);
            orderResponse.setCount(count.get());
        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), pageInfo.getList());
    }

    /**
     * 订单支付
     *
     * @param payOrderRequest
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> payOrder(PayOrderRequest payOrderRequest) {
        // 根据订单id查询订单信息
        Order oldOrder = this.orderMapper.getOrderByOrderId(payOrderRequest.getOrderId());
        // 判断订单是否存在

        // 判断订单金额是否一致
        if (!oldOrder.getTotalPay().equals(payOrderRequest.getTotalPay())) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_MONEY_ERROR.getMsg());
        }
        Order order = new Order();
        order.setId(payOrderRequest.getOrderId());
        order.setActualPay(payOrderRequest.getTotalPay());
        // 修改订单信息
        this.orderMapper.updatePayOrder(order);

        // 修改订单状态
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderId(payOrderRequest.getOrderId());
        orderStatus.setPayTime(new Date());
        // 设置订单为已支付，未发货
        orderStatus.setOrderStatus(2);
        // 执行修改
        this.orderStatusMapper.updateOrderStatus(orderStatus);
        // 删除redis中的订单id
        this.stringRedisTemplate.delete(String.valueOf(order.getId()));
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_PAY_SUCCESS.getMsg());
    }

    /**
     * 自动关闭失效订单
     *
     * @param orderId
     */
    @Override
    @Transactional
    public void autoCloseOrder(Long orderId) {

        if (ObjectUtil.isEmpty(orderId) || orderId <= 0) {
            log.error("订单号无效：{}", orderId);
        }
        // 根据订单号查询订单是否存在,且属于未付款订单
        OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderId(orderId);
        // 订单不存在
        if (ObjectUtil.isEmpty(orderStatus)) {
            log.error("订单不存在：{}", orderId);
        }
        // 订单状态不正确,只有状态为1才能自动取消订单
        if (orderStatus.getOrderStatus() != 1) {
            log.error("订单状态错误，{}", orderId);
        }
        // 执行修改订单状态
        orderStatus.setCloseTime(new Date());
        orderStatus.setOrderId(orderId);
        orderStatus.setOrderStatus(7);
        this.orderStatusMapper.updateOrderStatus(orderStatus);
        log.error("订单已关闭，订单号：{}", orderId);
    }

    /**
     * 查询商户下的订单信息
     *
     * @param orderSearchRequest
     * @return
     */
    @Override
    public FCResponse<List<OrderResponse>> getPageMerchantOrder(OrderSearchRequest orderSearchRequest) {
        // 从Token获取信息
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData) || !StringUtils.equals("merchant", loginInfoData.getResources())) {
            throw new FCException("登录失效，请重新登录");
        }
        // 根据id获取商户号
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            throw new FCException(merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        PageHelper.startPage(orderSearchRequest.getPage(), orderSearchRequest.getLimit());
        // 根据商户号查询商户下的订单
        Map<String, Object> map = new HashMap<>();
        map.put("merchantNumber", merchantResponse.getNumber());
        map.put("orderStatus", orderSearchRequest.getOrderStatus());
        List<OrderResponse> orderResponses = this.orderMapper.getPageMerchantOrder(map);
        // 无订单信息
        if (CollectionUtils.isEmpty(orderResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg(), orderResponses);
        }
        PageInfo<OrderResponse> pageInfo = new PageInfo<>(orderResponses);
        // 循环查询订单下的商品信息
        pageInfo.getList().forEach(orderResponse -> {
            // 根据订单编号查询订单下的商品详细信息
            Map<String, Object> orderDetailMap = new HashMap<>();
            orderDetailMap.put("orderId", orderResponse.getOrderId());
            orderDetailMap.put("merchantNumber", merchantResponse.getNumber());
            List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderIdAndMerchantNumber(orderDetailMap);
            if (CollectionUtils.isEmpty(orderDetails)) {
                log.error("该订单号下无商品信息");
                throw new FCException("系统异常");
            }
            AtomicReference<Long> totalPay = new AtomicReference<>(0L);
            AtomicReference<Integer> count = new AtomicReference<>(0);
            List<ProductModel> productModels = new ArrayList<>();
            orderDetails.forEach(orderDetail -> {
                ProductModel productModel = new ProductModel();
                ProductSkuModel productSkuModel = new ProductSkuModel();
                // 设置商品信息
                productModel.setProductCount(orderDetail.getProductCount());
                productModel.setProductImage(orderDetail.getProductImage());
                productModel.setProductTitle(orderDetail.getProductTitle());
                // 设置sku信息
                productSkuModel = JsonUtils.parse(orderDetail.getProductSkuDetail(), ProductSkuModel.class);
                productModel.setProductSkuModel(productSkuModel);
                productModels.add(productModel);
                assert productSkuModel != null;
                totalPay.set(productModel.getProductCount() * productSkuModel.getPrice());
                count.updateAndGet(v -> v + orderDetail.getProductCount());
            });
            orderResponse.setTotalPay(totalPay.get());
            orderResponse.setCount(count.get());
            orderResponse.setProductModels(productModels);
        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), pageInfo.getList());
    }

    /**
     * 系统订单查询显示
     *
     * @param orderSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<OrderPageResponse>>> getSystemPageOrder(OrderSearchRequest orderSearchRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效，请重新登录");
        }
        MerchantResponse merchantResponse = null;
        // 判断属于那种标识--商户标识
        if ("merchant".equals(loginInfoData.getResources())) {
            // 根据商户id获取商户信息
            FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
            if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), merchantFcResponse.getMsg());
            }
            merchantResponse = merchantFcResponse.getData();
            orderSearchRequest.setMerchantNumber(merchantResponse.getNumber());
        } else {
            // 系统标识
            orderSearchRequest.setMerchantNumber(null);
        }
        PageHelper.startPage(orderSearchRequest.getPage(), orderSearchRequest.getLimit());
        List<OrderPageResponse> orderPageResponses = this.orderMapper.getSystemPageOrder(orderSearchRequest);
        if (CollectionUtils.isEmpty(orderPageResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg(), DataResponse.dataResponse(orderPageResponses, 0L));
        }
        PageInfo<OrderPageResponse> pageInfo = new PageInfo<>(orderPageResponses);
        // 循环查询订单下的商品信息
        MerchantResponse finalMerchantResponse = merchantResponse;
        pageInfo.getList().forEach(orderResponse -> {
            // 根据订单编号查询订单下的商品详细信息
            Map<String, Object> orderDetailMap = new HashMap<>();
            orderDetailMap.put("orderId", orderResponse.getOrderId());
            // 若merchantResponse为Null，则为系统查询
            if (ObjectUtils.isEmpty(finalMerchantResponse)) {
                orderDetailMap.put("merchantNumber", null);
            } else {
                // 否则为商户查询
                orderDetailMap.put("merchantNumber", finalMerchantResponse.getNumber());
            }
            List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderIdAndMerchantNumber(orderDetailMap);
            if (CollectionUtils.isEmpty(orderDetails)) {
                log.error("该订单号下无商品信息");
                throw new FCException("系统异常");
            }
            AtomicReference<Integer> count = new AtomicReference<>(0);
            List<ProductModel> productModels = new ArrayList<>();
            orderDetails.forEach(orderDetail -> {
                ProductModel productModel = new ProductModel();
                ProductSkuModel productSkuModel = new ProductSkuModel();
                // 设置商品信息
                productModel.setProductCount(orderDetail.getProductCount());
                productModel.setProductImage(orderDetail.getProductImage());
                productModel.setProductTitle(orderDetail.getProductTitle());
                // 设置sku信息
                productSkuModel = JsonUtils.parse(orderDetail.getProductSkuDetail(), ProductSkuModel.class);
                productModel.setProductSkuModel(productSkuModel);
                productModels.add(productModel);
                assert productSkuModel != null;
                count.updateAndGet(v -> v + orderDetail.getProductCount());
            });
            orderResponse.setCount(count.get());
            orderResponse.setProductModels(productModels);
        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 根据订单号获取订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public FCResponse<OrderDetailResponse> getOrderInfoById(Long orderId) {
        if (ObjectUtils.isEmpty(orderId) || orderId <= 0) {
            log.error("订单ID错误：{}", orderId);
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单号查询订单基本信息
        OrderDetailResponse orderDetailResponse = this.orderMapper.getOrderInfoById(orderId);
        if (ObjectUtils.isEmpty(orderDetailResponse)) {
            log.error("订单数据为空，订单号：{}", orderId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        // 根据地址Id获取地收货人信息
        FCResponse<ReceiverAddress> receiverAddressFCResponse = this.memberClient.getReceiverAddressByAddressId(orderDetailResponse.getAddressId());

        if (!receiverAddressFCResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), receiverAddressFCResponse.getMsg());
        }
        ReceiverAddress receiverAddress = receiverAddressFCResponse.getData();
        // 设置收货信息
        orderDetailResponse.setReceiverName(receiverAddress.getName());
        orderDetailResponse.setReceiverPhone(receiverAddress.getPhone());
        orderDetailResponse.setReceiverAddress(receiverAddress.getArea() + receiverAddress.getDetailed() + receiverAddress.getHouseNumber());
        // 根据订单号查询查询商品信息
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetails)) {
            log.error("订单下无商品信息：{}", orderId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        List<ProductModel> productModels = new ArrayList<>();
        // 循环设置商品信息
        orderDetails.forEach(orderDetail -> {
            ProductModel productModel = new ProductModel();
            ProductSkuModel productSkuModel = new ProductSkuModel();
            // 设置商品信息
            productModel.setProductCount(orderDetail.getProductCount());
            productModel.setProductImage(orderDetail.getProductImage());
            productModel.setProductTitle(orderDetail.getProductTitle());
            // 设置sku信息
            productSkuModel = JsonUtils.parse(orderDetail.getProductSkuDetail(), ProductSkuModel.class);
            productModel.setProductSkuModel(productSkuModel);
            productModels.add(productModel);
        });
        orderDetailResponse.setProductModels(productModels);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), orderDetailResponse);
    }

    /**
     * 获取订单状态下的数量
     *
     * @return
     */
    @Override
    public FCResponse<OrderStatusCount> getOrderStatusCount() {

        // 获取当前登录用户
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效，请重新登录");
        }
        // 获取登录会员的id
        Long memberId = loginInfoData.getId();
        // 根据会员id查询订单状态下的数量
        List<OrderCount> orderCounts = this.orderMapper.getOrderStatusCount(memberId);
        if (CollectionUtils.isEmpty(orderCounts)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        OrderStatusCount orderStatusCount = new OrderStatusCount();
        orderCounts.forEach(orderCount -> {
            switch (orderCount.getOrderStatus()) {
                // 待付款
                case 1:
                    orderStatusCount.setPendingPaymentCount(orderCount.getOrderCount());
                    break;
                // 未发货
                case 2:
                    orderStatusCount.setToBeDeliveredCount(orderCount.getOrderCount());
                    break;
                // 待收货
                case 3:
                    orderStatusCount.setToBeReceivedCount(orderCount.getOrderCount());
                    break;
                // 已完成
                case 4:
                    orderStatusCount.setCompletedCount(orderCount.getOrderCount());
                    break;
                // 待评价
                case 6:
                    orderStatusCount.setComment(orderCount.getOrderCount());
                    break;
            }
        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), orderStatusCount);
    }

    /**
     * 订单发货
     *
     * @param orderDeliveryMessage
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> orderDelivery(OrderDeliveryMessage orderDeliveryMessage) {

        String name = DeliveryEnum.getDeliveryNameByKey(orderDeliveryMessage.getLogisticsCompany());
        if (StringUtils.isEmpty(name)) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.delivery.DELIVERY_SN_ERROR.getMsg());
        }

        Order order = new Order();
        order.setId(orderDeliveryMessage.getOrderId());
        order.setOrderDeliveryCompany(name);
        order.setOrderDeliverySn(orderDeliveryMessage.getLogisticsCompany());
        order.setOrderDeliveryNumber(DeliveryNumberUtil.getDeliveryNumber(orderDeliveryMessage.getLogisticsCompany()));
        // 修改订单
        try {
            this.orderMapper.orderDelivery(order);
            // 修改订单状态
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(order.getId());
            orderStatus.setOrderStatus(3);
            orderStatus.setConsignTime(new Date());
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.delivery.DELIVERY_ORDER_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 订单退款
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> refundOrder(Long orderId) {
        if (ObjectUtils.isEmpty(orderId) || orderId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单id查询是否存在
        OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderId(orderId);
        if (ObjectUtils.isEmpty(orderStatus)) {
            log.info("退款订单不存在，订单id为{}", orderId);
        }
        // 判断当前订单的状态是否是未发货
        if (orderStatus.getOrderStatus() != 2){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.order.ORDER_STATUS_ERROR.getMsg());
        }
        // 发起退款
        OrderReturn orderReturn = new OrderReturn();
        orderReturn.setOrderReturnId(idWorker.nextId());
        orderReturn.setOrderId(orderId);
        // 设置为0订单退款退货待处理
        orderReturn.setOrderReturnStatus(0);
        orderReturn.setOrderReturnApplyTime(new Date());
        try {
            // 发起退款货
            this.orderReturnMapper.addOrderReturn(orderReturn);
            // 将订单状态修改为售后服务
            orderStatus.setOrderId(orderId);
            orderStatus.setOrderStatus(8);
            orderStatus.setCloseTime(new Date());
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.order.ORDER_RETURN_APPLY_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
