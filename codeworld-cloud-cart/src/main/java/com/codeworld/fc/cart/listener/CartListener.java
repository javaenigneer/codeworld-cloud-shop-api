package com.codeworld.fc.cart.listener;

import com.codeworld.fc.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName CartListener
 * Description 购物车消息监听
 * Author Lenovo
 * Date 2021/1/11
 * Version 1.0
 **/
@Component
@Slf4j
public class CartListener {

    @Autowired(required = false)
    private CartService cartService;

    /**
     * 购物车删除
     * @param cartIds
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.CART.DELETE.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"cart.delete"}
    ))
    public void deleteCartByIds(String cartIds) {
        if (ObjectUtils.isEmpty(cartIds)) {
            log.error("购物车Id错误：{}",cartIds);
        }
        this.cartService.deleteCartByIds(cartIds);
        log.info("购物车删除消息已消费：购物车Id{}",cartIds);
    }
}
