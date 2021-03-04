package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderDetail;
import com.codeworld.fc.order.response.MerchantDashBoardData;
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
     * 根据母订单编号查询订单下的商品详细信息
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

    /**
     * 订单发货
     * @param orderDetail
     */
    void orderDelivery(OrderDetail orderDetail);

    /**
     * 根据订单明细id查询订单明细
     * @param orderDetailId
     * @return
     */
    List<OrderDetail> getOrderDetailByOrderDetailId(Long orderDetailId);

    /**
     * 查询商户下所有的订单数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardOrderTotalCount(String number);

    /**
     * 查询商户下待付款总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardPendingPayCount(String number);

    /**
     * 查询商户下待发货总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardToBeDeliveredCount(String number);

    /**
     * 查询商户下已发货总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardShippedCount(String number);

    /**
     * 查询商户下已收货总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardReceivedCount(String number);

    /**
     * 查询商户下退款中总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardRefundingCount(String number);

    /**
     * 查询商户下待处理-待售后总数
     * @param number
     * @return
     */
    Integer getMerchantDashBoardAfterSaleCount(String number);

    /**
     * 根据订单号和物流号查询是否存在
     * @param map
     * @return
     */
    OrderDetail checkOrderIdAndDeliveryNumberExist(Map<String, Object> map);
}
