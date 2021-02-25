package com.codeworld.fc.marketing.task;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.marketing.carouse.entity.Carouse;
import com.codeworld.fc.marketing.carouse.service.CarouseService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName CarouseJob
 * Description 轮播图调度任务
 * Author Lenovo
 * Date 2021/1/14
 * Version 1.0
**/
@Component
@Slf4j
public class CarouseJob {

    @Autowired(required = false)
    private CarouseService carouseService;

    /**
     * 轮播图上线
     * @param param
     * @return
     */
    @XxlJob(value = "updateCarouseEnable")
    public ReturnT<String> updateCarouseEnable(String param){
        Long startTime = System.currentTimeMillis();
        log.info("轮播图上线任务开始执行，描述信息：{}",param);
        // 将其序列化
        Carouse carouse = JsonUtils.parse(param, Carouse.class);
        if (ObjectUtils.isEmpty(carouse)){
            log.info("轮播图收到的信息为空，{}",param);
        }
        // 修改轮播图的状态
        try {
            assert carouse != null;
            carouse.setStatus(1);
            this.carouseService.updateCarouseStatus(carouse);
            Long endTime = System.currentTimeMillis();
            log.info("轮播图上线任务执行完成，耗时{}",endTime - startTime);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

    /**
     * 轮播图下线
     * @param param
     * @return
     */
    @XxlJob(value = "updateCarouseDisable")
    public ReturnT<String> updateCarouseDisable(String param){
        Long startTime = System.currentTimeMillis();
        log.info("轮播图下线任务开始执行，描述信息：{}",param);
        // 将其序列化
        Carouse carouse = JsonUtils.parse(param, Carouse.class);
        if (ObjectUtils.isEmpty(carouse)){
            log.info("轮播图收到的信息为空，{}",param);
        }
        // 修改轮播图的状态
        try {
            assert carouse != null;
            carouse.setStatus(0);
            this.carouseService.updateCarouseStatus(carouse);
            Long endTime = System.currentTimeMillis();
            log.info("轮播图下线任务执行完成，耗时{}",endTime - startTime);
        }catch (Exception e){
            e.printStackTrace();
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

    /**
     * 定时查询并删除
     */
    // 删除结束时间已过的轮播图，设置状态为-1
    @XxlJob(value = "deleteCarouseTime")
    public ReturnT<String> deleteCarouseTime(String param){
        Long startTime = System.currentTimeMillis();
        log.info("轮播图定时删除任务开始执行，当前时间{}", DateUtil.date(new Date()));
        try {
            // 查询结束时间大于当前日期一天的轮播图
            List<Long> carouseIds = this.carouseService.getCarouseEndTimeGtNow();
            if (CollectionUtils.isEmpty(carouseIds)){
                Long endTime = System.currentTimeMillis();
                log.info("轮播图任务执行完成,耗时{}",endTime - startTime);
                return ReturnT.SUCCESS;
            }
            this.carouseService.deleteCarouseTime(carouseIds);
            Long endTime = System.currentTimeMillis();
            log.info("轮播图定时删除任务执行完成，耗时{}",endTime - startTime);
            return ReturnT.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ReturnT.FAIL;
        }
    }
}
