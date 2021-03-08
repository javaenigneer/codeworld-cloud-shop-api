package com.codeworld.fc.logistics.mapper;

import com.codeworld.fc.logistics.entity.Logistics;
import com.codeworld.fc.logistics.request.LogisticsSelectRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogisticsMapper {


    /**
     * 物流MQ监听发货（自动更新）
     * @param logistics
     * @return
     */
    Integer logisticsDelivery(Logistics logistics);

    /**
     * 根据订单编号和物流单号查询物流信息
     * @param logisticsSelectRequest
     * @return
     */
    List<Logistics> getLogisticsByDeliveruNumberAndOrderId(LogisticsSelectRequest logisticsSelectRequest);
}
