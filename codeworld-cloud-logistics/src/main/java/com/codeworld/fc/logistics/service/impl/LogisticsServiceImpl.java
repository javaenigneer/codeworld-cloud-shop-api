package com.codeworld.fc.logistics.service.impl;

import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.logistics.entity.Logistics;
import com.codeworld.fc.logistics.mapper.LogisticsMapper;
import com.codeworld.fc.logistics.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName LogisticsServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/3/3
 * Version 1.0
 **/
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired(required = false)
    private LogisticsMapper logisticsMapper;

    /**
     * 物流MQ监听发货（自动更新）
     *
     * @param logistics
     * @return
     */
    public Integer logisticsDelivery(Logistics logistics) {
        // 设置基本信息
        logistics.setId(IDGeneratorUtil.getNextId());
        logistics.setArriveTime(new Date());
        logistics.setContent("订单开始处理");
        try {
            this.logisticsMapper.logisticsDelivery(logistics);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
