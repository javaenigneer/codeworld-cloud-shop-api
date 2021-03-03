package com.codeworld.fc.listener;

import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.logistics.entity.Logistics;
import com.codeworld.fc.logistics.service.LogisticsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ClassName LogisticsListener
 * Description 物流MQ监听
 * Author Lenovo
 * Date 2021/3/3
 * Version 1.0
 **/
@Component
@Slf4j
public class LogisticsListener {

    @Autowired(required = false)
    private LogisticsService logisticsService;

    /**
     * 物流发货
     *
     * @param json
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.LOGISTICS.DELIVERY.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"logistics.delivery"}
    ))
    public void logisticsDelivery(String json) {
        if (ObjectUtils.isEmpty(json)) {
            log.error("物流发货收到参数为空");
            return;
        }
        Logistics logistics = JsonUtils.parse(json, Logistics.class);
        if (ObjectUtils.isEmpty(logistics)) {
            log.error("物流发货参数Json转换错误：{}", json);
            return;
        }
        try {
            Integer flag = this.logisticsService.logisticsDelivery(logistics);
            if (flag > 0) {
                log.info("物流发货成功，物流信息：{}", json);
                return;
            }
            log.info("物流发货失败，物流信息：{}", json);
        } catch (Exception e) {
            log.error("系统错误");
        }
    }
}
