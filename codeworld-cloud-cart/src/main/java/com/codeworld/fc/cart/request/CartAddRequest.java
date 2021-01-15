package com.codeworld.fc.cart.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName CartAddRequest
 * Description 购物车添加Model
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("购物车添加Model")
public class CartAddRequest {

    @ApiModelProperty("会员Id")
    @NotNull(message = "会员Id为空")
    private Long memberId;

    @ApiModelProperty("商品详情")
    @NotNull(message = "商品详情为空")
    private String productDetail;

    @ApiModelProperty("Sku详情")
    @NotNull(message = "Sku详情为空")
    private String skuDetail;
}
