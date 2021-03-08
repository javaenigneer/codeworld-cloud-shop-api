package com.codeworld.fc.logistics.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.logistics.entity.Logistics;
import com.codeworld.fc.logistics.request.LogisticsRequest;
import com.codeworld.fc.logistics.request.LogisticsSelectRequest;
import com.codeworld.fc.logistics.response.LogisticsInformationCollection;

public interface LogisticsService {
    /**
     * 物流MQ监听发货（自动更新）
     * @param logistics
     * @return
     */
    Integer logisticsDelivery(Logistics logistics);

    /**
     * 物流更新
     * @param logisticsRequest
     * @return
     */
    FCResponse<Void> updateLogistics(LogisticsRequest logisticsRequest);

    /**
     * 获取物流信息
     * @param logisticsSelectRequest
     * @return
     */
    FCResponse<LogisticsInformationCollection> getLogisticsInformation(LogisticsSelectRequest logisticsSelectRequest);
}
