package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ProductModel
 * Description 商品Model
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("商品Model")
public class ProductModel {

    @ApiModelProperty("商品Id")
    private Long productId;

    @ApiModelProperty("商品标题")
    private String productTitle;

    @ApiModelProperty("商品图片")
    private String productImage;

    @ApiModelProperty("商品数量")
    private Integer productCount;

    @ApiModelProperty("商品Sku信息")
    private ProductSkuModel productSkuModel;

}
