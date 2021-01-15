package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderDetailMapper {
    /**
     * 保存订单明细
     * @param orderDetail
     */
    void saveOrderDetail(OrderDetail orderDetail);

    /**
     * 根据订单编号查询订单下的商品详细信息
     * @param orderId
     * @return
     */
    List<OrderDetail> getOrderDetailByOrderId(Long orderId);

    /**
     * 根据订单号和商户号查询订单详情
     * @param orderDetailMap
     * @return
     */
    List<OrderDetail> getOrderDetailByOrderIdAndMerchantNumber(Map<String, Object> orderDetailMap);
}
