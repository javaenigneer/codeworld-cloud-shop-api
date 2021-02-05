package com.codeworld.fc.order.listener;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.IdWorker;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.order.client.MemberClient;
import com.codeworld.fc.order.domain.MemberInfo;
import com.codeworld.fc.order.domain.OrderAddAsyn;
import com.codeworld.fc.order.domain.ProductInfoSkuModel;
import com.codeworld.fc.order.domain.ProductSkuModel;
import com.codeworld.fc.order.entity.Order;
import com.codeworld.fc.order.entity.OrderDetail;
import com.codeworld.fc.order.entity.OrderStatus;
import com.codeworld.fc.order.mapper.OrderDetailMapper;
import com.codeworld.fc.order.mapper.OrderMapper;
import com.codeworld.fc.order.mapper.OrderStatusMapper;
import com.codeworld.fc.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * ClassName OrderListener
 * Description 订单MQ监听器
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
 **/
@Component
@Slf4j
public class OrderListener {

    @Autowired(required = false)
    private OrderService orderService;
    @Autowired(required = false)
    private OrderStatusMapper orderStatusMapper;

    /**
     * 创建订单
     *
     * @param map
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.ORDER.CREATE.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"order.create"}
    ))
    public Long createOrder(Map<String, Object> map) {
        String orderJson = (String) map.get("orderAddAsync");
        OrderAddAsyn orderAddAsync = JsonUtils.parse(orderJson, OrderAddAsyn.class);
        String jsonProduct = (String) map.get("productInfoSkuModels");
        List<ProductInfoSkuModel> productInfoSkuModels = JsonUtils.parseList(jsonProduct, ProductInfoSkuModel.class);
        if (ObjectUtils.isEmpty(orderAddAsync) || ObjectUtils.isEmpty(productInfoSkuModels)) {
            log.info("订单创建失败，失败原因：订单基本数据丢失");
            throw new FCException("系统错误-订单创建失败");
        }
        try {
            Long orderId = this.orderService.createOrderAsync(map);
            if (ObjectUtils.isEmpty(orderId)) {
                log.error("消息消费失败，失败原因：订单创建失败");
                return null;
            }
            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 取消订单
     *
     * @param orderDetailIds
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.ORDER.CANCEL.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"order.cancel"}
    ))
    public void cancelOrder(List<Long> orderDetailIds) {
        try {
            orderDetailIds.forEach(orderDetailId -> {
                OrderStatus orderStatus = new OrderStatus();
                orderStatus.setOrderId(orderDetailId);
                orderStatus.setOrderStatus(5);
                orderStatus.setCloseTime(new Date());
                this.orderStatusMapper.updateOrderStatus(orderStatus);
            });
            log.info("订单取消成功，订单号有{}",orderDetailIds);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
