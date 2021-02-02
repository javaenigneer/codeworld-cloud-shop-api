package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderReturn;
import com.codeworld.fc.order.request.OrderSearchRequest;
import com.codeworld.fc.order.response.OrderReturnDetailResponse;
import com.codeworld.fc.order.response.OrderReturnResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderReturnMapper {
    /**
     * 发起退款和退货
     * @param orderReturn
     */
    void addOrderReturn(OrderReturn orderReturn);

    /**
     * 查询订单退款退货列表
     * @param orderSearchRequest
     * @return
     */
    List<OrderReturnResponse> getPageMerchantOrderReturn(OrderSearchRequest orderSearchRequest);

    /**
     * 根据订单退款退货id查询是否存在
     * @param orderReturnId
     * @return
     */
    Integer selectOrderReturnExistById(Long orderReturnId);

    /**
     * 获取订单退款退货详情
     * @param orderReturnId
     * @return
     */
    OrderReturnDetailResponse getOrderReturnInfo(Long orderReturnId);

    /**
     * 根据服务订单号查询服务订单信息
     * @param orderReturnId
     * @return
     */
    OrderReturn getOrderReturnById(Long orderReturnId);

    /**
     * 修改服务订单
     * @param orderReturn
     */
    void updateOrderReturn(OrderReturn orderReturn);
}
