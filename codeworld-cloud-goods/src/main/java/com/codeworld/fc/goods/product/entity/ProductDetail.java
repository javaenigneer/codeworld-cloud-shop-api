package com.codeworld.fc.goods.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * ClassName ProductDetail
 * Description 商品详情
 * Author Lenovo
 * Date 2020/12/2
 * Version 1.0
**/
@Data
@ApiModel("商品详情")
public class ProductDetail {

    @ApiModelProperty("商品id")
    private Long id;
    @ApiModelProperty("商品介绍")
    private String desc;
    @ApiModelProperty("商品通用参数")
    private String genericParam;
    @ApiModelProperty("商品特殊参数")
    private String specialParam;
    @ApiModelProperty("商品图片")
    private String images;
    @ApiModelProperty("包装清单")
    private String packingList;
    @ApiModelProperty("售后服务")
    private String afterService;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("商品浏览量")
    private Long view;
    @ApiModelProperty("通用参数map类型")
    private Map<String, Object> genericParamMap;
}
