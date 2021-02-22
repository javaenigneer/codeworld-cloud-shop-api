package com.codeworld.fc.order.mapper;

import com.codeworld.fc.order.entity.OrderEvaluation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderEvaluationMapper {


    /**
     * 订单商品评价
     * @param orderEvaluation
     */
    void orderProductEvaluation(OrderEvaluation orderEvaluation);
}
