package com.codeworld.fc.order.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.OrderDeliveryMessage;
import com.codeworld.fc.order.request.*;
import com.codeworld.fc.order.response.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface OrderService {

    /**
     * 创建订单
     * @param orderAddRequest
     * @return
     */
    FCResponse<String> createOrder(OrderAddRequest orderAddRequest);

    /**
     * 分页查询当前用户订单信息
     * @param orderSearchRequest
     * @return
     */
    FCResponse<List<OrderResponse>> getPageMemberOrder(OrderSearchRequest orderSearchRequest);

    /**
     * 订单支付
     * @param payOrderRequest
     * @return
     */
    FCResponse<Void> payOrder(PayOrderRequest payOrderRequest);

    /**
     * 关闭订单
     * @param orderId
     */
    void autoCloseOrder(Long orderId);

    /**
     * 查询商户下的订单信息
     * @param orderSearchRequest
     * @return
     */
    FCResponse<List<OrderResponse>> getPageMerchantOrder(OrderSearchRequest orderSearchRequest);

    /**
     * 系统订单查询显示
     * @param orderSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<OrderPageResponse>>> getSystemPageOrder(OrderSearchRequest orderSearchRequest);

    /**
     * 根据订单号获取订单信息
     * @param orderDetailId
     * @return
     */
    FCResponse<OrderDetailResponse> getOrderInfoById(Long orderDetailId);

    /**
     * 获取订单状态下的数量
     * @return
     */
    FCResponse<OrderStatusCount> getOrderStatusCount();

    /**
     * 订单发货
     * @param orderDeliveryMessage
     * @return
     */
    FCResponse<Void> orderDelivery(OrderDeliveryMessage orderDeliveryMessage);

    /**
     * 订单退款
     * @param orderId
     * @return
     */
    FCResponse<Void> refundOrder(Long orderId);

    /**
     * 获取商户下订单退款退货列表
     * @param orderSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<OrderReturnResponse>>> getPageMerchantOrderReturn(OrderSearchRequest orderSearchRequest);

    /**
     * 获取订单退款退货详情
     * @param orderReturnId
     * @return
     */
    FCResponse<OrderReturnDetailResponse> getOrderReturnInfo(Long orderReturnId);

    /**
     * 接受处理订单服务
     * @param orderProcessingRequest
     * @return
     */
    FCResponse<Void> receiveProcessingServiceOrder(OrderProcessingRequest orderProcessingRequest);

    /**
     * 导出订单数据
     * @param response
     */
    void exportExcel(HttpServletResponse response);

    /**
     * 拒绝处理订单服务
     * @param orderProcessingRequest
     * @return
     */
    FCResponse<Void> refuseProcessServiceOrder(OrderProcessingRequest orderProcessingRequest);

    /**
     * 异步创建订单
     * @param map
     * @return
     */
    Long createOrderAsync(Map<String, Object> map);

    /**
     * 查询web端商户下的订单列表
     * @param orderSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<OrderPageResponse>>> getWebPageMerchantOrder(OrderSearchRequest orderSearchRequest);

    /**
     * app端取消订单
     * @param orderId
     * @return
     */
    FCResponse<Void> cancelOrder(Long orderId);

    /**
     * web端获取商户dashboard基本数据
     * @return
     */
    FCResponse<MerchantDashBoardData> getMerchantDashBoardData();

    /**
     * 订单收货
     * @param orderDetailId
     * @return
     */
    FCResponse<Void> confirmReceipt(Long orderDetailId);

    /**
     * 订单商品评价
     * @param orderEvaluationRequest
     * @return
     */
    FCResponse<Void> orderProductEvaluation(OrderEvaluationRequest orderEvaluationRequest);

    /**
     * 订单退货申请
     * @param orderReturnRequest
     * @return
     */
    FCResponse<Void> orderReturnApply(OrderReturnRequest orderReturnRequest);

    /**
     * 根据订单号和物流号查询是否存在
     * @param orderId
     * @param deliveryNumber
     * @return
     */
    FCResponse<Boolean> checkOrderIdAndDeliveryNumberExist(Long orderId, String deliveryNumber);
}
