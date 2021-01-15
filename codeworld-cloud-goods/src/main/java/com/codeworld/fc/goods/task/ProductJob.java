package com.codeworld.fc.goods.task;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.client.SearchClient;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName ProductJob
 * Description 商品任务Job
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
 **/
@Component
@Slf4j
public class ProductJob {

    @Autowired(required = false)
    private SearchClient searchClient;

    /**
     * 每隔半小时导入商品到索引库
     * @param param
     */
    @XxlJob(value = "importGoodsToElasticSearchTime")
    public ReturnT<String> importGoodsToElasticSearchTime(String param) {
        log.info("商品导入索引库开始执行任务,当前时间：{}", DateUtil.date(new Date()));
        FCResponse<Void> response = this.searchClient.importGoodsToElasticSearchTime();
        if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            log.error("商品导入索引库任务执行失败,当前时间：{}", DateUtil.date(new Date()));
            return ReturnT.FAIL;
        }
        log.error("商品导入索引库任务执行成功,当前时间：{}", DateUtil.date(new Date()));
        return ReturnT.SUCCESS;
    }
}
