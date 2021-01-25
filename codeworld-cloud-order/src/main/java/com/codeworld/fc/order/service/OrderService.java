package com.codeworld.fc.order.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.OrderDeliveryMessage;
import com.codeworld.fc.order.request.OrderAddRequest;
import com.codeworld.fc.order.request.OrderSearchRequest;
import com.codeworld.fc.order.request.PayOrderRequest;
import com.codeworld.fc.order.response.OrderDetailResponse;
import com.codeworld.fc.order.response.OrderPageResponse;
import com.codeworld.fc.order.response.OrderResponse;
import com.codeworld.fc.order.response.OrderStatusCount;

import java.util.List;

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
     * @param orderId
     * @return
     */
    FCResponse<OrderDetailResponse> getOrderInfoById(Long orderId);

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
}
