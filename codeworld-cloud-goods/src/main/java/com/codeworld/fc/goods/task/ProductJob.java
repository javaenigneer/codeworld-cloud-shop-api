package com.codeworld.fc.goods.task;

import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.client.SearchClient;
import com.codeworld.fc.goods.product.entity.ProductDetail;
import com.codeworld.fc.goods.product.mapper.ProductDetailMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    private ProductDetailMapper productDetailMapper;

    // 用于保存商品浏览到redis中的前缀
    private static final String PRODUCT_VIEW = "PRODUCT_VIEW:";

    /**
     * 每隔半小时导入商品到索引库
     *
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

    /**
     * 每天晚上2点更新商品浏览、销量、
     *
     * @param param
     */
    @XxlJob(value = "updateProductView")
    public ReturnT<String> updateProductView(String param) {
        log.info("商品浏览量同步数据库任务开始,当前时间：{}", DateUtil.date(new Date()));
        try {
            // 获取全部以PRODUCT_VIEW开头redis中的key
            Set<String> keys = this.stringRedisTemplate.keys(PRODUCT_VIEW + "*");
            assert keys != null;
            for (String key : keys
            ) {
                // 获取Key,并去除key中的前部分PRODUCT_VIEW
                Long productId = Long.parseLong(key.substring(13));
                // 获取key对应的value
                Long viewCount = Long.parseLong(Objects.requireNonNull(this.stringRedisTemplate.opsForValue().get(key)));
                // 修改商品浏览量
                ProductDetail productDetail = new ProductDetail();
                productDetail.setId(productId);
                productDetail.setView(viewCount);
                this.productDetailMapper.updateProductView(productDetail);
                // 删除redis中的Key
                this.stringRedisTemplate.delete(key);
            }
            log.info("商品浏览量同步数据库任务执行成功,当前时间：{}", DateUtil.date(new Date()));
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("商品浏览量同步数据库任务执行失败,当前时间：{}", DateUtil.date(new Date()));
            return ReturnT.FAIL;
        }
    }
}
