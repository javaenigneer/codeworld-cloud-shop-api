package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderStatusMapper {
    /**
     * 保存订单状态
     * @param orderStatus
     */
    void saveOrderStatus(OrderStatus orderStatus);

    /**
     * 修改订单状态
     * @param orderStatus
     */
    void updateOrderStatus(OrderStatus orderStatus);

    /**
     * 根据订单id查询订单状态信息
     * @param orderId
     * @return
     */
    OrderStatus getOrderStatusByOrderId(Long orderId);
}
