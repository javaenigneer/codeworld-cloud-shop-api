package com.codeworld.fc.order.listener;

import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * ClassName RedisMessageListener
 * Description Redis Key过期监听器
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
 **/
@Component
@Slf4j
public class RedisMessageListener extends KeyExpirationEventMessageListener {


    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    private OrderService orderService;

    public RedisMessageListener(RedisMessageListenerContainer listenerContainer){
        super(listenerContainer);
        log.info("Redis过期监听已启动");
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取Key
        String orderId = (String) this.stringRedisTemplate.getValueSerializer().deserialize(message.getBody());
        // 收到过期异步通知
        log.info("收到过期异步通知，Key：{}", orderId);
        // 将失效订单关闭
        assert orderId != null;
        this.orderService.autoCloseOrder(Long.parseLong(orderId));
    }

}
