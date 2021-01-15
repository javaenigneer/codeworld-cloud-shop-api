package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ProductInfoSkuModel
 * Description 商品和SkuModel
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@Data
@ApiModel("商品和SkuModel")
public class ProductInfoSkuModel {

    @ApiModelProperty("商品Id")
    private Long productId;

    @ApiModelProperty("商品标题")
    private String productTitle;

    @ApiModelProperty("商品图片")
    private String productImage;

    @ApiModelProperty("商品数量")
    private Integer productCount;

    @ApiModelProperty("商品SkuId")
    private Long id;

    @ApiModelProperty("商品价格")
    private Long price;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("图片")
    private String images;

    @ApiModelProperty("商户号")
    private String merchantNumber;
}
