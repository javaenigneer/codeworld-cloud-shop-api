package com.codeworld.fc.goods.product.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ClassName ProductResponse
 * Description 商品列表信息Response
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@Data
@ApiModel("商品列表信息Response")
public class ProductResponse {

    @ApiModelProperty("商品Id")
    private Long id;
    @ApiModelProperty("商品标题")
    private String title;
    @ApiModelProperty("商品二级标题")
    private String subtitle;
    @ApiModelProperty("分类Id")
    private Long categoryId;
    @ApiModelProperty("分类名")
    private String categoryName;
    @ApiModelProperty("品牌名")
    private String brandName;
    @ApiModelProperty("商品状态 1-上架 0-下架")
    private Integer saleAble;
    @ApiModelProperty("商品图片")
    private String image;
    @ApiModelProperty("商品图片集")
    private List<String> images;
    @ApiModelProperty("添加时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("商户Id")
    private Long merchantId;
    @ApiModelProperty("商品浏览量")
    private Long view;
    @ApiModelProperty("门店Id")
    private Long storeId;
    @ApiModelProperty("审核状态")
    private Integer approveStatus;
}
