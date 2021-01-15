package com.codeworld.fc.order.request;

import com.codeworld.fc.order.domain.ProductInfoSkuModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * ClassName OrderAddRequest
 * Description 订单创建Request
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@Data
@ApiModel("订单创建Request")
public class OrderAddRequest implements Serializable {

    @ApiModelProperty("地址Id")
    @NotNull(message = "地址为空")
    private Long addressId;

    @ApiModelProperty("订单总金额")
    @NotNull(message = "订单总金额有错")
    private Long payTotal;

    @ApiModelProperty("购买的数量")
    private Integer buyNum;

    @ApiModelProperty("会员Id")
    @NotNull(message = "会员Id为空")
    private Long memberId;

    @ApiModelProperty("购物车Id")
    @NotNull(message = "购物车Id为空")
    private String cartIds;

    @ApiModelProperty("商品和Sku信息")
    @NotNull(message = "商品信息不能为空")
    private String productInfoSkuModels;
}
