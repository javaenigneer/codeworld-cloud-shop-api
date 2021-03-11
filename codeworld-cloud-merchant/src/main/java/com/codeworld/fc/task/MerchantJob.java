package com.codeworld.fc.task;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.merchant.mapper.MerChantDetailMapper;
import com.codeworld.fc.merchant.mapper.MerchantMapper;
import com.codeworld.fc.merchant.response.MerchantResponse;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName MerchantJob
 * Description 商户任务调度Job
 * Author Lenovo
 * Date 2021/1/7
 * Version 1.0
**/
@Component
@Slf4j
public class MerchantJob {

    @Autowired(required = false)
    private MerchantMapper merchantMapper;

    @Autowired(required = false)
    private MerChantDetailMapper merChantDetailMapper;

    /**
     * 每隔10分钟定时清除商户注册后七天内未入住
     * @param param
     * @return
     */
    @XxlJob(value = "cleanNoSetMerchant")
    @Transactional
    public ReturnT<String> cleanNoSetMerchant(String param) {

        log.info("清除商户开始执行任务,当前时间：{}", DateUtil.date(new Date()));
        // 查询商户注册后七天内未入驻,状态为3
        List<MerchantResponse> merchantResponses = this.merchantMapper.getAllNoMerchantSet();
        if (CollectionUtils.isEmpty(merchantResponses)){
            log.info("清除商户任务执行完成,当前时间：{}，商户数据为空，没有要清除的",DateUtil.date(new Date()));
            return ReturnT.SUCCESS;
        }
        // 循环将其删除
        try {
            List<String> merchantNumbers = merchantResponses.stream().map(MerchantResponse::getNumber).collect(Collectors.toList());
            // 执行删除
            this.merchantMapper.deleteNoMerchantSet(merchantNumbers);
            // 删除商户详细表
            this.merChantDetailMapper.deleteNoMerchantSet(merchantNumbers);
            log.info("清除商户任务执行完成,当前时间：{}，已删除商户数据",DateUtil.date(new Date()));
            return ReturnT.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ReturnT.FAIL;
        }
    }
}
