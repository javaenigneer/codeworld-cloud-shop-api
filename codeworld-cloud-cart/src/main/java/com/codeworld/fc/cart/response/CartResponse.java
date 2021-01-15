package com.codeworld.fc.cart.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName CartResponse
 * Description 购物车数据返回Model
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("购物车数据返回Model")
public class CartResponse {

    @ApiModelProperty("购物车主键Id")
    private Long id;

    @ApiModelProperty("会员id")
    private Long memberId;

    @ApiModelProperty("商品id")
    private Long productId;

    @ApiModelProperty("商品SkuId")
    private Long productSkuId;

    @ApiModelProperty("商品标题")
    private String productTitle;

    @ApiModelProperty("商品数量")
    private Integer productCount;

    @ApiModelProperty("商品是否删除 1--未删除 0--已删除")
    private Integer productStatus;

    @ApiModelProperty("商品图片")
    private String productImage;

    @ApiModelProperty("商品Sku")
    private String productSku;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("商户号")
    private String merchantNumber;
}
