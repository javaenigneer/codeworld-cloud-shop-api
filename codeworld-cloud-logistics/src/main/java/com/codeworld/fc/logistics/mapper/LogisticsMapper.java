package com.codeworld.fc.logistics.mapper;

import com.codeworld.fc.logistics.entity.Logistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LogisticsMapper {


    /**
     * 物流MQ监听发货（自动更新）
     * @param logistics
     * @return
     */
    Integer logisticsDelivery(Logistics logistics);
}
