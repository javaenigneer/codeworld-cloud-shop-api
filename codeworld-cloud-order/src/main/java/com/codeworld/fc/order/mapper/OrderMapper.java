package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.domain.OrderCount;
import com.codeworld.fc.order.entity.Order;
import com.codeworld.fc.order.request.OrderSearchRequest;
import com.codeworld.fc.order.response.OrderDetailResponse;
import com.codeworld.fc.order.response.OrderPageResponse;
import com.codeworld.fc.order.response.OrderResponse;
import com.codeworld.fc.order.response.OrderStatusCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 分页查询订单基本信息
     * @param map
     * @return
     */
    List<OrderResponse> getPageMemberOrder(Map<String, Object> map);

    /**
     * 修改订单信息
     * @param order
     */
    void updatePayOrder(Order order);

    /**
     * 根据订单id查询订单信息
     * @param orderId
     * @return
     */
    Order getOrderByOrderId(Long orderId);

    /**
     * 分页查询商户下的订单信息
     * @param map
     * @return
     */
    List<OrderResponse> getPageMerchantOrder(Map<String, Object> map);

    /**
     * 获取Web端订单列表
     * @param orderSearchRequest
     * @return
     */
    List<OrderPageResponse> getSystemPageOrder(OrderSearchRequest orderSearchRequest);

    /**
     * 根据订单号获取订单详细信息
     * @param orderId
     * @return
     */
    OrderDetailResponse getOrderInfoById(Long orderId);

    /**
     * 根据会员id查询订单状态下的数量
     * @param memberId
     * @return
     */
    List<OrderCount> getOrderStatusCount(Long memberId);

    /**
     * 订单发货
     * @param order
     */
    void orderDelivery(Order order);
}
