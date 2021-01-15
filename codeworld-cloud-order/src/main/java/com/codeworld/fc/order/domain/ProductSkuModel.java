package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ProductSkuModel
 * Description 商品SkuModel
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("商品SkuModel")
public class ProductSkuModel {

    @ApiModelProperty("商品SkuId")
    private Long id;

    @ApiModelProperty("商品价格")
    private Long price;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("图片")
    private String images;
}
