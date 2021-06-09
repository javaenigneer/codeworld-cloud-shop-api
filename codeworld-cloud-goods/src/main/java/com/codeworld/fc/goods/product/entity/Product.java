package com.codeworld.fc.goods.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Product
 * Description 商品Model
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@Data
@ApiModel("商品Model")
public class Product {

    @ApiModelProperty("商品Id")
    private Long id;
    @ApiModelProperty("商品标题")
    private String title;
    @ApiModelProperty("商品二级标题")
    private String subTitle;
    @ApiModelProperty("分类Id")
    private Long categoryId;
    @ApiModelProperty("品牌Id")
    private Long brandId;
    @ApiModelProperty("商品状态 1-上架 0-下架")
    private Integer saleAble;
    @ApiModelProperty("商户Id")
    private Long merchantId;
    @ApiModelProperty("添加时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("审核状态 1--审核通过 0--审核未通过 -1--未审核")
    private Integer approveStatus;
    @ApiModelProperty("审核备注信息")
    private String approveRemark;
}
