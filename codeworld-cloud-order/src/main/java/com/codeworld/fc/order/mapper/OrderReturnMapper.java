package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderReturn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderReturnMapper {
    /**
     * 发起退款和退货
     * @param orderReturn
     */
    void addOrderReturn(OrderReturn orderReturn);
}
