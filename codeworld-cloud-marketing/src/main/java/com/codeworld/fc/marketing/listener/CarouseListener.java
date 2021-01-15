package com.codeworld.fc.marketing.listener;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.domain.XxlJobInfo;
import com.codeworld.fc.common.utils.DateUtils;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.common.utils.XxlUtil;
import com.codeworld.fc.marketing.carouse.entity.Carouse;
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

/**
 * ClassName CarouseListener
 * Description 轮播图监听Listener
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@Component
@Slf4j
public class CarouseListener {

    @Autowired(required = false)
    private XxlUtil xxlUtil;

    /**
     * 轮播图上线
     * @param json
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.MARKETING.CAROUSE.UPDATE", durable = "false"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE",ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"carouse.update.status.enable"}
    ))
    public void updateCarouseStatusEnable(String json){
        log.info("RabbitMQ收到消息，异步更新轮播图为上线，当前时间{}", DateUtil.date(new Date()));
        if (ObjectUtils.isEmpty(json)){
            log.error("收到的参数为空");
            return;
        }
        Carouse carouse = JsonUtils.parse(json, Carouse.class);
        if (ObjectUtils.isEmpty(carouse)){
            log.error("Json转化为对象Null");
            return;
        }
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setJobDesc("轮播图上线");
        xxlJobInfo.setAuthor("admin");
        xxlJobInfo.setScheduleType("CRON");
        xxlJobInfo.setScheduleConf(DateUtils.getCron(carouse.getStartTime()));
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setExecutorHandler("updateCarouseEnable");
        xxlJobInfo.setJobGroup(5);
        xxlJobInfo.setExecutorParam(json);
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setMisfireStrategy("DO_NOTHING");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setTriggerStatus(1);
        xxlUtil.addJob(xxlJobInfo, "xxl-job-marketing");
        log.info("轮播图任务添加成功，将在{}上线，轮播图Id{}",DateUtil.date(carouse.getStartTime()),carouse.getId());
    }

    /**
     * 轮播图下线
     * @param json
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CODEWORLD.CLOUD.MARKETING.CAROUSE.UPDATE", durable = "false"),
            exchange = @Exchange(value = "CODEWORLD-SHOP.EXCHANGE",ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"carouse.update.status.disable"}
    ))
    public void updateCarouseStatusDisable(String json){
        log.info("RabbitMQ收到消息，异步更新轮播图为下线，当前时间{}", DateUtil.date(new Date()));
        if (ObjectUtils.isEmpty(json)){
            log.error("收到的参数为空");
            return;
        }
        Carouse carouse = JsonUtils.parse(json, Carouse.class);
        if (ObjectUtils.isEmpty(carouse)){
            log.error("Json转化为对象Null");
            return;
        }
        XxlJobInfo xxlJobInfo = new XxlJobInfo();
        xxlJobInfo.setJobDesc("轮播图下线");
        xxlJobInfo.setAuthor("admin");
        xxlJobInfo.setScheduleType("CRON");
        xxlJobInfo.setScheduleConf(DateUtils.getCron(carouse.getEndTime()));
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setExecutorHandler("updateCarouseDisable");
        xxlJobInfo.setJobGroup(5);
        xxlJobInfo.setExecutorParam(json);
        xxlJobInfo.setExecutorRouteStrategy("FIRST");
        xxlJobInfo.setMisfireStrategy("DO_NOTHING");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        xxlJobInfo.setTriggerStatus(1);
        xxlUtil.addJob(xxlJobInfo, "xxl-job-marketing");
        log.info("轮播图任务添加成功，将在{}下线，轮播图Id{}",DateUtil.date(carouse.getEndTime()),carouse.getId());
    }

}
