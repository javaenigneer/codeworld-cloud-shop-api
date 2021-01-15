package com.codeworld.fc.goods.stock.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName Stock
 * Description 商品库存Model
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@Data
@ApiModel("商品库存Model")
public class Stock {

    @ApiModelProperty("商品SkuId")
    private Long productSkuId;

    @ApiModelProperty("商品库存")
    private Integer stock;
}
