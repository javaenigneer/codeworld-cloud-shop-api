package com.codeworld.fc.order.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.DeliveryEnum;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.*;
import com.codeworld.fc.order.client.CartClient;
import com.codeworld.fc.order.client.MemberClient;
import com.codeworld.fc.order.client.MerchantClient;
import com.codeworld.fc.order.client.StockClient;
import com.codeworld.fc.order.domain.*;
import com.codeworld.fc.order.entity.*;
import com.codeworld.fc.order.interceptor.AuthInterceptor;
import com.codeworld.fc.order.mapper.*;
import com.codeworld.fc.order.properties.OrderExcelProperties;
import com.codeworld.fc.order.request.*;
import com.codeworld.fc.order.response.*;
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
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
    private StockClient stockClient;

    @Autowired(required = false)
    private OrderMapper orderMapper;
    @Autowired(required = false)
    private OrderStatusMapper orderStatusMapper;
    @Autowired(required = false)
    private OrderDetailMapper orderDetailMapper;
    @Autowired(required = false)
    private OrderReturnMapper orderReturnMapper;
    @Autowired(required = false)
    private OrderEvaluationMapper orderEvaluationMapper;

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    private AmqpTemplate amqpTemplate;

    @Autowired(required = false)
    private IdWorker idWorker;
    @Autowired(required = false)
    private OrderExcelProperties orderExcelProperties;

    @Autowired(required = false)
    private ExcelUtil excelUtil;

    /**
     * 创建订单
     *
     * @param orderAddRequest
     * @return
     */
    @Override
    @Transactional
    public FCResponse<String> createOrder(OrderAddRequest orderAddRequest) {
        // 将Json装换位List对象
        List<ProductInfoSkuModel> productInfoSkuModels = JsonUtils.parseList(orderAddRequest.getProductInfoSkuModels(), ProductInfoSkuModel.class);
        // 判断商品库存是否充足
        assert productInfoSkuModels != null;
        productInfoSkuModels.forEach(productInfoSkuModel -> {
            // 首先查询商品库库存是否充足
            CommodityStocks commodityStocks = new CommodityStocks();
            commodityStocks.setProductSkuId(productInfoSkuModel.getId());
            commodityStocks.setLockedNumber(productInfoSkuModel.getProductCount());
            FCResponse<Boolean> response = this.stockClient.judgeStockAdequate(commodityStocks);
            if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode()) | !response.getData()) {
                throw new FCException(response.getMsg());
            }
            // 将库存减掉
            this.stockClient.updateProductStockMinus(commodityStocks);
        });
        FCResponse<MemberInfo> memberResponse = this.memberClient.getMemberById(orderAddRequest.getMemberId());
        if (!memberResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.info("订单创建失败，失败原因：未找到该会员信息，会员Id为{}", orderAddRequest.getMemberId());
            throw new FCException("系统错误-订单创建失败");
        }
        MemberInfo memberInfo = memberResponse.getData();
        // 异步添加订单
        Map<String, Object> map = new HashMap<>();
        OrderAddAsyn orderAddAsyn = new OrderAddAsyn();
        BeanUtil.copyProperties(orderAddRequest, orderAddAsyn);
        // 将其序列化字符串
        String jsonOrder = JsonUtils.serialize(orderAddAsyn);
        String jsonProduct = JsonUtils.serialize(productInfoSkuModels);
        String jsonMemberInfo = JsonUtils.serialize(memberInfo);
        assert jsonOrder != null;
        map.put("orderAddAsync", jsonOrder);
        assert jsonProduct != null;
        map.put("productInfoSkuModels", jsonProduct);
        map.put("memberInfo", jsonMemberInfo);
        // 异步创建订单
        Long orderId = (Long) this.amqpTemplate.convertSendAndReceive("order.create", map);
        if (ObjectUtils.isEmpty(orderId)) {
            throw new FCException("系统错误");
        }
        // 异步删除购物车中对应的数据（使用RabbitMQ消息队列）
        this.amqpTemplate.convertAndSend("cart.delete", orderAddRequest.getCartIds());
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_CREATE_SUCCESS.getMsg(), orderId.toString());
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
            List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderDetailId(orderResponse.getOrderDetailId());
            if (CollectionUtils.isEmpty(orderDetails)) {
                log.error("该订单号下无商品信息");
                throw new FCException("系统异常");
            }
            List<ProductModel> productModels = new ArrayList<>();
            orderDetails.forEach(orderDetail -> {
                OrderResponse newOrderResponse = new OrderResponse();
                // 设置订单信息
                newOrderResponse.setOrderId(orderResponse.getOrderId());
                newOrderResponse.setCreateTime(orderResponse.getCreateTime());
                newOrderResponse.setOrderStatus(orderResponse.getOrderStatus());
//                newOrderResponse.setTotalPay();
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
        if (ObjectUtils.isEmpty(oldOrder)) {
            // 判断订单是否存在
            log.error("订单不存在");
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
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
        // 根据母订单id查询子订单信息即订单详细
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderId(order.getId());
        // 获取子订单明细id
        List<Long> orderDetailIds = orderDetails.stream().map(OrderDetail::getDetailId).collect(Collectors.toList());
        // 修改子订单订单状态
        orderDetailIds.forEach(orderDetailId -> {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(orderDetailId);
            orderStatus.setPayTime(new Date());
            // 设置订单为已支付，未发货
            orderStatus.setOrderStatus(2);
            // 执行修改
            this.orderStatusMapper.updateOrderStatus(orderStatus);
        });
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
        // 根据订单号查询是否存在订单
        Order order = this.orderMapper.getOrderByOrderId(orderId);
        if (ObjectUtils.isEmpty(order)) {
            log.error("订单不存在，订单号为{}", orderId);
            return;
        }
        // 根据母订单查询子订单
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderId(orderId);
        if (ObjectUtils.isEmpty(orderDetails)) {
            log.error("订单详细不存在：订单号为{}", orderId);
            return;
        }
        // 查询订单明细订单状态
        List<Long> orderDetailIds = orderDetails.stream().map(OrderDetail::getDetailId).collect(Collectors.toList());
        orderDetailIds.forEach(orderDetailId -> {
            OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderDetailId(orderDetailId);
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
            orderStatus.setOrderId(orderDetailId);
            orderStatus.setOrderStatus(7);
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            log.info("订单已关闭，订单号：{}", orderId);
        });

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
            orderDetailMap.put("orderId", orderResponse.getOrderDetailId());
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
     * @param orderDetailId
     * @return
     */
    @Override
    public FCResponse<OrderDetailResponse> getOrderInfoById(Long orderDetailId) {
        if (ObjectUtils.isEmpty(orderDetailId) || orderDetailId <= 0) {
            log.error("订单ID错误：{}", orderDetailId);
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单号查询订单基本信息
        OrderDetailResponse orderDetailResponse = this.orderMapper.getOrderInfoById(orderDetailId);
        if (ObjectUtils.isEmpty(orderDetailResponse)) {
            log.error("订单数据为空，订单号：{}", orderDetailId);
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
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderDetailId(orderDetailId);
        if (CollectionUtils.isEmpty(orderDetails)) {
            log.error("订单下无商品信息：{}", orderDetailId);
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
                case 9:
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
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId(orderDeliveryMessage.getOrderDetailId());
        orderDetail.setOrderDeliveryCompany(name);
        orderDetail.setOrderDeliverySn(orderDeliveryMessage.getLogisticsCompany());
        orderDetail.setOrderDeliveryNumber(DeliveryNumberUtil.getDeliveryNumber(orderDeliveryMessage.getLogisticsCompany()));
        // 修改订单
        try {
            this.orderDetailMapper.orderDelivery(orderDetail);
            // 修改订单状态
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(orderDetail.getDetailId());
            orderStatus.setOrderStatus(3);
            orderStatus.setConsignTime(new Date());
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            // 设置基本的物流信息
            Logistics logistics = new Logistics();
            logistics.setOrderId(orderDetail.getDetailId());
            logistics.setDeliverySn(orderDetail.getOrderDeliverySn());
            logistics.setDeliveryNumber(orderDetail.getOrderDeliveryNumber());
            // 异步通知物流系统(已发货)
            this.amqpTemplate.convertAndSend("logistics.delivery", JsonUtils.serialize(logistics));
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.delivery.DELIVERY_ORDER_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 订单退款
     *
     * @param orderDetailId
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> refundOrder(Long orderDetailId) {
        if (ObjectUtils.isEmpty(orderDetailId) || orderDetailId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单明细id查询是否存在
        OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderDetailId(orderDetailId);
        if (ObjectUtils.isEmpty(orderStatus)) {
            log.info("退款订单不存在，订单id为{}", orderDetailId);
        }
        // 判断当前订单的状态是否是未发货
        if (orderStatus.getOrderStatus() != 2) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_STATUS_ERROR.getMsg());
        }
        // 发起退款
        OrderReturn orderReturn = new OrderReturn();
        orderReturn.setOrderReturnId(idWorker.nextId());
        orderReturn.setOrderId(orderDetailId);
        // 设置为0订单退款退货待处理
        orderReturn.setOrderReturnStatus(0);
        // 设置为订单为退款类型
        orderReturn.setOrderReturnType(1);
        orderReturn.setOrderReturnApplyTime(new Date());
        try {
            // 发起退款货
            this.orderReturnMapper.addOrderReturn(orderReturn);
            // 将订单状态修改为售后服务
            orderStatus.setOrderId(orderDetailId);
            orderStatus.setOrderStatus(8);
            orderStatus.setCloseTime(new Date());
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_RETURN_APPLY_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取商户下订单退款退货列表
     *
     * @param orderSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<OrderReturnResponse>>> getPageMerchantOrderReturn(OrderSearchRequest orderSearchRequest) {
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
        orderSearchRequest.setMerchantNumber(merchantResponse.getNumber());
        List<OrderReturnResponse> orderReturnResponses = this.orderReturnMapper.getPageMerchantOrderReturn(orderSearchRequest);
        if (CollectionUtils.isEmpty(orderReturnResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg(), DataResponse.dataResponse(orderReturnResponses, 0L));
        }
        PageInfo<OrderReturnResponse> pageInfo = new PageInfo<>(orderReturnResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 获取订单退款退货详情
     *
     * @param orderReturnId
     * @return
     */
    @Override
    public FCResponse<OrderReturnDetailResponse> getOrderReturnInfo(Long orderReturnId) {
        // 根据订单退款退货id查询是否存在
        Integer count = this.orderReturnMapper.selectOrderReturnExistById(orderReturnId);
        if (count == 0) {
            log.info("订单退款退货详情不存在，id为{}", orderReturnId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        OrderReturnDetailResponse orderReturnDetailResponse = this.orderReturnMapper.getOrderReturnInfo(orderReturnId);
        if (ObjectUtils.isEmpty(orderReturnDetailResponse)) {
            log.info("订单退款退货详情不存在，id为{}", orderReturnId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        // 根据地址Id获取地收货人信息
        FCResponse<ReceiverAddress> receiverAddressFCResponse = this.memberClient.getReceiverAddressByAddressId(orderReturnDetailResponse.getAddressId());
        if (!receiverAddressFCResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), receiverAddressFCResponse.getMsg());
        }
        ReceiverAddress receiverAddress = receiverAddressFCResponse.getData();
        // 设置收货信息
        orderReturnDetailResponse.setReceiverName(receiverAddress.getName());
        orderReturnDetailResponse.setReceiverPhone(receiverAddress.getPhone());
        orderReturnDetailResponse.setReceiverAddress(receiverAddress.getArea() + receiverAddress.getDetailed() + receiverAddress.getHouseNumber());

        // 根据订单号查询查询商品信息
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderDetailId(orderReturnDetailResponse.getOrderId());
        if (CollectionUtils.isEmpty(orderDetails)) {
            log.error("订单下无商品信息：{}", orderReturnDetailResponse.getOrderId());
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
        orderReturnDetailResponse.setProductModels(productModels);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), orderReturnDetailResponse);
    }

    /**
     * 接受处理订单服务
     *
     * @param orderProcessingRequest
     * @return
     */
    @Override
    public FCResponse<Void> receiveProcessingServiceOrder(OrderProcessingRequest orderProcessingRequest) {
        if (ObjectUtils.isEmpty(orderProcessingRequest.getOrderReturnId()) || orderProcessingRequest.getOrderReturnId() <= 0) {
            log.error("服务订单号错误,服务订单号为：{}", orderProcessingRequest.getOrderReturnId());
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_ID_ERROR.getMsg());
        }
        // 根据服务订单id查询信息
        OrderReturn orderReturn = this.orderReturnMapper.getOrderReturnById(orderProcessingRequest.getOrderReturnId());
        if (ObjectUtils.isEmpty(orderReturn)) {
            log.error("没有服务订单信息，服务订单号为：{}", orderProcessingRequest.getOrderReturnId());
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_DATA_EMPTY.getMsg());
        }
        // 判断订单状态是否为未处理
        if (orderReturn.getOrderReturnStatus() != 0) {
            log.error("服务订单号状态错误，该服务订单已被处理");
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_PROCESSED.getMsg());
        }
        // 修改服务订单信息
        orderReturn.setOrderReturnStatus(1);
        orderReturn.setOrderReturnRemark(orderProcessingRequest.getRemark());
        orderReturn.setOrderReturnHandleTime(new Date());
        try {
            this.orderReturnMapper.updateOrderReturn(orderReturn);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.orderReturn.ORDER_RETURN_ACCEPTED_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 导出订单数据
     *
     * @param response
     */
    @Override
    public void exportExcel(HttpServletResponse response) {
        // 获取当前登录商户
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        // 根据id获取商户号
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            throw new FCException(merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        Map<String, Object> map = new HashMap<>();
        map.put("merchantNumber", merchantResponse.getNumber());
        log.info("开始执行导出Excel");
        String[] colName = this.orderExcelProperties.getTitle().split(",");
        // 获取导出数据信息
        List<OrderExcel> orderExcels = this.orderMapper.getOrderExcel(map);
        // 设置导出数据信息
        orderExcels = this.changeOrderExcel(orderExcels);
        /*定义相关变量*/
        List<Object[]> printDataList = new ArrayList<Object[]>();
        //组合得到生成数据的数组
        for (int i = 0; i < orderExcels.size(); i++) {
            printDataList.add(orderExcels.get(i).getFieldArray());
        }
        try {
            this.excelUtil.exportOrderExcel(response, "订单数据.xls", "订单数据", colName, printDataList);
            log.info("订单数据导出完成");
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 拒绝处理订单服务
     *
     * @param orderProcessingRequest
     * @return
     */
    @Override
    public FCResponse<Void> refuseProcessServiceOrder(OrderProcessingRequest orderProcessingRequest) {

        if (ObjectUtils.isEmpty(orderProcessingRequest.getOrderReturnId()) || orderProcessingRequest.getOrderReturnId() <= 0) {
            log.error("服务订单号错误,服务订单号为：{}", orderProcessingRequest.getOrderReturnId());
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_ID_ERROR.getMsg());
        }
        // 根据服务订单id查询信息
        OrderReturn orderReturn = this.orderReturnMapper.getOrderReturnById(orderProcessingRequest.getOrderReturnId());
        if (ObjectUtils.isEmpty(orderReturn)) {
            log.error("没有服务订单信息，服务订单号为：{}", orderProcessingRequest.getOrderReturnId());
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_DATA_EMPTY.getMsg());
        }
        // 判断订单状态是否为未处理
        if (orderReturn.getOrderReturnStatus() != 0) {
            log.error("服务订单号状态错误，该服务订单已被处理");
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.orderReturn.ORDER_RETURN_PROCESSED.getMsg());
        }
        // 修改服务订单信息，拒绝退款
        orderReturn.setOrderReturnStatus(5);
        orderReturn.setOrderReturnRemark(orderProcessingRequest.getRemark());
        orderReturn.setOrderReturnHandleTime(new Date());
        try {
            this.orderReturnMapper.updateOrderReturn(orderReturn);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.orderReturn.ORDER_RETURN_ACCEPTED_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 异步创建订单
     *
     * @param map
     * @return
     */
    @Override
    @Transactional
    public Long createOrderAsync(Map<String, Object> map) {
        String orderJson = (String) map.get("orderAddAsync");
        OrderAddAsyn orderAddAsync = JsonUtils.parse(orderJson, OrderAddAsyn.class);
        String jsonProduct = (String) map.get("productInfoSkuModels");
        List<ProductInfoSkuModel> productInfoSkuModels = JsonUtils.parseList(jsonProduct, ProductInfoSkuModel.class);
        String jsonMemberInfo = (String) map.get("memberInfo");
        MemberInfo memberInfo = JsonUtils.parse(jsonMemberInfo, MemberInfo.class);
        // 根据会员id查询会员信息
        assert orderAddAsync != null;
        // 创建订单信息
        Order order = new Order();
        order.setId(idWorker.nextId());
        order.setMemberId(orderAddAsync.getMemberId());
        assert productInfoSkuModels != null;
        order.setTotalPay(orderAddAsync.getPayTotal());
        assert memberInfo != null;
        order.setBuyerName(memberInfo.getMemberName());
        order.setAddressId(orderAddAsync.getAddressId());
        order.setCreateTime(new Date());
        List<CommodityStocks> commodityStockses = new ArrayList<>();
        // 创建订单
        try {
            this.orderMapper.createOrder(order);
            // 循环商品信息，保存订单明细
            productInfoSkuModels.forEach(productInfoSkuModel -> {
                // 首先查询商品库库存是否充足
                CommodityStocks commodityStocks = new CommodityStocks();
                commodityStocks.setProductSkuId(productInfoSkuModel.getId());
                commodityStocks.setLockedNumber(productInfoSkuModel.getProductCount());
                // 进行商品拆分订单
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setDetailId(idWorker.nextId());
                orderDetail.setOrderId(order.getId());
                orderDetail.setCreateTime(new Date());
                orderDetail.setMerchantNumber(productInfoSkuModel.getMerchantNumber());
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
                // 添加订单明细
                this.orderDetailMapper.saveOrderDetail(orderDetail);
                // 保存子订单状态
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setOrderId(orderDetail.getDetailId());
                orderStatus.setCreateTime(orderDetail.getCreateTime());
                // 默认这是为未支付状态
                orderStatus.setOrderStatus(1);
                this.orderStatusMapper.saveOrderStatus(orderStatus);
                commodityStockses.add(commodityStocks);
            });
            log.info("生成订单，订单编号：{}，用户id：{}", order.getId(), memberInfo.getMemberId());
            // 将订单信息保存到redis缓存中,时间为10分钟，10分钟过后将其置为失效订单
            // 将订单id作为Key，订单信息作为value
            Map<String, Object> newMap = new HashMap<>(3);
            newMap.put("orderId", order.getId());
            newMap.put("totalPay", order.getTotalPay());
            newMap.put("commodityStocks", JsonUtils.serialize(commodityStockses));
            // 将map进行序列化
            String json = JsonUtils.serialize(map);
            assert json != null;
            this.stringRedisTemplate.opsForValue().set(String.valueOf(order.getId()), json, 60 * 10, TimeUnit.SECONDS);
            log.info("订单加入Redis缓存，订单编号：{}，用户id：{}，将在10分钟后过期", order.getId(), memberInfo.getMemberId());
            return order.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 查询web端商户下的订单列表
     *
     * @param orderSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<OrderPageResponse>>> getWebPageMerchantOrder(OrderSearchRequest orderSearchRequest) {

        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效，请重新登录");
        }
        // 根据商户id获取商户信息
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        orderSearchRequest.setMerchantNumber(merchantResponse.getNumber());
        PageHelper.startPage(orderSearchRequest.getPage(), orderSearchRequest.getLimit());
        List<OrderPageResponse> orderPageResponses = this.orderMapper.getWebPageMerchantOrder(orderSearchRequest);
        if (CollectionUtils.isEmpty(orderPageResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg(), DataResponse.dataResponse(orderPageResponses, 0L));
        }
        PageInfo<OrderPageResponse> pageInfo = new PageInfo<>(orderPageResponses);
        // 循环查询订单下的商品信息
//        MerchantResponse finalMerchantResponse = merchantResponse;
//        pageInfo.getList().forEach(orderResponse -> {
//            // 根据订单编号查询订单下的商品详细信息
//            Map<String, Object> orderDetailMap = new HashMap<>();
//            orderDetailMap.put("orderId", orderResponse.getOrderId());
//            // 若merchantResponse为Null，则为系统查询
//            if (ObjectUtils.isEmpty(finalMerchantResponse)) {
//                orderDetailMap.put("merchantNumber", null);
//            } else {
//                // 否则为商户查询
//                orderDetailMap.put("merchantNumber", finalMerchantResponse.getNumber());
//            }
//            List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderIdAndMerchantNumber(orderDetailMap);
//            if (CollectionUtils.isEmpty(orderDetails)) {
//                log.error("该订单号下无商品信息");
//                throw new FCException("系统异常");
//            }
//            AtomicReference<Integer> count = new AtomicReference<>(0);
//            List<ProductModel> productModels = new ArrayList<>();
//            orderDetails.forEach(orderDetail -> {
//                ProductModel productModel = new ProductModel();
//                ProductSkuModel productSkuModel = new ProductSkuModel();
//                // 设置商品信息
//                productModel.setProductCount(orderDetail.getProductCount());
//                productModel.setProductImage(orderDetail.getProductImage());
//                productModel.setProductTitle(orderDetail.getProductTitle());
//                // 设置sku信息
//                productSkuModel = JsonUtils.parse(orderDetail.getProductSkuDetail(), ProductSkuModel.class);
//                productModel.setProductSkuModel(productSkuModel);
//                productModels.add(productModel);
//                assert productSkuModel != null;
//                count.updateAndGet(v -> v + orderDetail.getProductCount());
//            });
//            orderResponse.setCount(count.get());
//            orderResponse.setProductModels(productModels);
//        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * app端取消订单
     *
     * @param orderId
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> cancelOrder(Long orderId) {
        if (ObjectUtils.isEmpty(orderId) || orderId <= 0) {
            log.error("取消订单失败，失败原因：订单号为空或者订单号小于0");
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单号查询订单信息
        Order order = this.orderMapper.getOrderByOrderId(orderId);
        if (ObjectUtils.isEmpty(order)) {
            log.error("取消订单失败，失败原因：没有该订单信息，订单号为：{}", orderId);
            FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        // 根据母订单号查询子集订单号
        List<OrderDetail> orderDetails = this.orderDetailMapper.getOrderDetailByOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetails)) {
            log.error("取消订单失败，失败原因：没有该订单详细信息，订单号为：{}", orderId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());
        }
        // 将其所有子集订单状态改为5，交易关闭
        List<Long> orderDetailIds = orderDetails.stream().map(OrderDetail::getDetailId).collect(Collectors.toList());
        // 放入到队列中异步取消
        this.amqpTemplate.convertAndSend("order.cancel", orderDetailIds);
        // 删除redis中的缓存
        // 删除redis中的订单id
        this.stringRedisTemplate.delete(String.valueOf(order.getId()));
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_CANCEL_SUCCESS.getMsg());
    }

    /**
     * web端获取商户dashboard基本数据
     *
     * @return
     */
    @Override
    public FCResponse<MerchantDashBoardData> getMerchantDashBoardData() {
        // 获取当前登录商户
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录过期，请重新登录");
        }
        // 根据商户id获取商户信息
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        MerchantDashBoardData merchantDashBoardData = new MerchantDashBoardData();
        // 分开查询各个数量
        // 查询所有的订单数量
        Integer orderTotalCount = this.orderDetailMapper.getMerchantDashBoardOrderTotalCount(merchantResponse.getNumber());
        merchantDashBoardData.setOrderTotalCount(orderTotalCount);
        // 查询待付款
        Integer pendingPaymentCount = this.orderDetailMapper.getMerchantDashBoardPendingPayCount(merchantResponse.getNumber());
        merchantDashBoardData.setPendingPaymentCount(pendingPaymentCount);
        // 查询待发货
        Integer toBeDeliveredCount = this.orderDetailMapper.getMerchantDashBoardToBeDeliveredCount(merchantResponse.getNumber());
        merchantDashBoardData.setToBeDeliveredCount(toBeDeliveredCount);
        // 查询已发货
        Integer shippedCount = this.orderDetailMapper.getMerchantDashBoardShippedCount(merchantResponse.getNumber());
        merchantDashBoardData.setShippedCount(shippedCount);
        // 查询已收货
        Integer receivedCount = this.orderDetailMapper.getMerchantDashBoardReceivedCount(merchantResponse.getNumber());
        merchantDashBoardData.setReceivedCount(receivedCount);
        // 查询退款中总数
        Integer refundingCount = this.orderDetailMapper.getMerchantDashBoardRefundingCount(merchantResponse.getNumber());
        merchantDashBoardData.setRefundingCount(refundingCount);
        // 查询待售后总数
        Integer afterSaleCount = this.orderDetailMapper.getMerchantDashBoardAfterSaleCount(merchantResponse.getNumber());
        merchantDashBoardData.setAfterSaleCount(afterSaleCount);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_DATA_SUCCESS.getMsg(), merchantDashBoardData);
    }

    /**
     * 订单收货
     *
     * @param orderDetailId
     * @return
     */
    @Override
    public FCResponse<Void> confirmReceipt(Long orderDetailId) {
        if (ObjectUtils.isEmpty(orderDetailId) || orderDetailId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.order.ORDER_ID_ERROR.getMsg());
        }
        // 根据订单明细id查询是否存在
        OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderDetailId(orderDetailId);
        if (ObjectUtils.isEmpty(orderStatus)) {
            log.info("退款订单不存在，订单id为{}", orderDetailId);
        }
        // 判断当前订单的状态是否是已发货
        if (orderStatus.getOrderStatus() != 3) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_STATUS_ERROR.getMsg());
        }
        // 修改订单信息为未评价
        orderStatus.setOrderStatus(9);
        orderStatus.setCloseTime(new Date());
        try {
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_CONFIRM_RECEIPT_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 订单商品评价
     *
     * @param orderEvaluationRequest
     * @return
     */
    @Override
    public FCResponse<Void> orderProductEvaluation(OrderEvaluationRequest orderEvaluationRequest) {
        OrderEvaluation orderEvaluation = new OrderEvaluation();
        BeanUtil.copyProperties(orderEvaluationRequest, orderEvaluation);
        String evaluationImage = orderEvaluationRequest.getEvaluationImages().stream().map(String::valueOf).collect(Collectors.joining(","));
        orderEvaluation.setEvaluationImage(evaluationImage);
        orderEvaluation.setEvaluationTime(new Date());
        try {
            this.orderEvaluationMapper.orderProductEvaluation(orderEvaluation);
            // 修改订单状态
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setOrderId(orderEvaluation.getOrderDetailId());
            // 设置订单已完成
            orderStatus.setOrderStatus(4);
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.orderEvaluation.ORDER_EVALUATION_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 订单退货申请
     *
     * @param orderReturnRequest
     * @return
     */
    @Override
    public FCResponse<Void> orderReturnApply(OrderReturnRequest orderReturnRequest) {
        // 根据订单明细id查询是否存在
        OrderStatus orderStatus = this.orderStatusMapper.getOrderStatusByOrderDetailId(orderReturnRequest.getOrderDetailId());
        if (ObjectUtils.isEmpty(orderStatus)) {
            log.info("退款订单不存在，订单id为{}", orderReturnRequest.getOrderDetailId());
            return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(), HttpMsg.order.ORDER_DATA_EMPTY.getMsg());

        }
        // 判断该订单状态是否是已完成
        if (orderStatus.getOrderStatus() != 4) {
            log.error("订单状态错误：订单号为{}", orderReturnRequest.getOrderDetailId());
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.order.ORDER_STATUS_ERROR.getMsg());
        }

        OrderReturn orderReturn = new OrderReturn();
        orderReturn.setOrderReturnId(idWorker.nextId());
        orderReturn.setOrderId(orderReturnRequest.getOrderDetailId());
        // 设置状态为未处理
        orderReturn.setOrderReturnStatus(0);
        // 设置订单服务为退货申请
        orderReturn.setOrderReturnType(3);
        orderReturn.setOrderReturnApplyTime(new Date());
        orderReturn.setOrderReturnReason(orderReturnRequest.getReason());
        try {
            this.orderReturnMapper.addOrderReturn(orderReturn);
            // 修改订单状态为售后服务状态为8
            orderStatus.setOrderStatus(8);
            this.orderStatusMapper.updateOrderStatus(orderStatus);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.order.ORDER_RETURN_APPLY_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 改变导出订单信息
     *
     * @param orderExcels
     * @return
     */
    private List<OrderExcel> changeOrderExcel(List<OrderExcel> orderExcels) {
        return orderExcels.stream().map(orderExcel -> {
            orderExcel.setOrderStatusMsg(getOrderStatusMsg(orderExcel.getOrderStatus()));
            return orderExcel;
        }).collect(Collectors.toList());
    }

    /**
     * 转换订单状态
     *
     * @param orderStatus
     * @return
     */
    public String getOrderStatusMsg(Integer orderStatus) {
        switch (orderStatus) {
            case 1:
                return "未付款";
            case 2:
                return "未发货";
            case 3:
                return "已发货";
            case 4:
                return "交易成功";
            case 5:
                return "交易关闭";
            case 6:
                return "已评价";
            case 7:
                return "失效订单";
            case 8:
                return "售后服务";
            default:
                return "无状态";
        }
    }
}
