package com.codeworld.fc.search.listener;

import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.search.domain.ElProductStatusDTO;
import com.codeworld.fc.search.service.GoodsService;
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
 * ClassName ProductListener
 * Description 商品消息监听
 * Author Lenovo
 * Date 2021/3/12
 * Version 1.0
 **/
@Component
@Slf4j
public class ProductListener {

    @Autowired(required = false)
    private GoodsService goodsService;

    /**
     * 更新ElasticSearch中商品状态
     *
     * @param json
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.EL.PRODUCT.SALEABLE.UPDATE.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"el.product.update.saleable"}
    ))
    public void updateProductStatus(String json) {
        if (ObjectUtils.isEmpty(json)) {
            log.error("异步更新ElasticSearch中的商品状态失败，失败原因参数为空：{}", json);
            return;
        }
        ElProductStatusDTO elProductStatusDTO = JsonUtils.parse(json, ElProductStatusDTO.class);
        if (ObjectUtils.isEmpty(elProductStatusDTO)) {
            log.error("异步更新ElasticSearch中的商品状态失败，失败原因：对象为Null：{}", json);
            return;
        }
        Boolean flag = this.goodsService.updateProductStatus(elProductStatusDTO);
        if (flag) {
            log.info("异步更新ElasticSearch中的商品状态成功，消息消费成功");
        } else {
            log.error("异步更新ElasticSearch中的商品状态失败，消息消费成功");
        }
    }

    /**
     * 删除ElasticSearch中商品
     *
     * @param id
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.EL.PRODUCT.DELETE.QUEUE", declare = "true"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"el.product.delete"}
    ))
    public void deleteGoods(Long id) {
        if (ObjectUtils.isEmpty(id)) {
            log.error("异步删除ElasticSearch中的商品失败，失败原因参数为空：{}", id);
            return;
        }
        Boolean flag = this.goodsService.deleteGoods(id);
        if (flag) {
            log.info("异步删除ElasticSearch中的商品成功，消息消费成功");
        } else {
            log.error("异步删除ElasticSearch中的商品失败，消息消费失败");
        }
    }
}
