package com.codeworld.fc.search.item;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * ClassName SearchItem
 * Description 搜索服务Item
 * Author Lenovo
 * Date 2020/12/15
 * Version 1.0
**/
@Document(indexName = "codeworld-cloud-shop-goods", type = "docs", shards = 1, replicas = 0)
@Data
public class SearchItem implements Serializable {

    // 商品Id
    @Id
    private Long productId;

    // 商品标题
    @Field(type = FieldType.Keyword, index = false)
    private String title;

    // 分类Id
    private Long categoryId;

    // 商品图片
    private String images;

    // 商品价格
    private String prices;

    // 商品标题
    private String allTitle;

    // 商户号
    private String merchantNumber;

    // 商家名称
    private String merchantName;

    // 创建时间
    private Date createTime;

    // 更细时间
    private Date updateTime;

    // 商品Sku
    @Field(type = FieldType.Keyword, index = false)
    private String sku;

    // 可搜索的规格参数，key是参数名，值是参数值
    private Map<String, Object> specs;

    // 商品特有参数
    private String specialParam;

    // 商品浏览量
    private Long view;

    public SearchItem() {
    }

    public SearchItem(Long productId, String title, Long categoryId, String images, String prices, String allTitle, String merchantNumber, String merchantName, Date createTime, Date updateTime, String sku, Map<String, Object> specs, String specialParam, Long view) {
        this.productId = productId;
        this.title = title;
        this.categoryId = categoryId;
        this.images = images;
        this.prices = prices;
        this.allTitle = allTitle;
        this.merchantNumber = merchantNumber;
        this.merchantName = merchantName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.sku = sku;
        this.specs = specs;
        this.specialParam = specialParam;
        this.view = view;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Map<String, Object> getSpecs() {
        return specs;
    }

    public void setSpecs(Map<String, Object> specs) {
        this.specs = specs;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getAllTitle() {
        return allTitle;
    }

    public void setAllTitle(String allTitle) {
        this.allTitle = allTitle;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSpecialParam() {
        return specialParam;
    }

    public void setSpecialParam(String specialParam) {
        this.specialParam = specialParam;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }
}
