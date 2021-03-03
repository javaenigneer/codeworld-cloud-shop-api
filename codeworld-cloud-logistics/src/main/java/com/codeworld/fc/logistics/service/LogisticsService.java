package com.codeworld.fc.logistics.service;

import com.codeworld.fc.logistics.entity.Logistics;

public interface LogisticsService {
    /**
     * 物流MQ监听发货（自动更新）
     * @param logistics
     * @return
     */
    Integer logisticsDelivery(Logistics logistics);
}
