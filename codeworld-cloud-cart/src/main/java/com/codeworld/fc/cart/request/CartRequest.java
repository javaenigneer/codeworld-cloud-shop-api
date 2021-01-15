package com.codeworld.fc.cart.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName CartRequest
 * Description 购物车请求数据Model
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("购物车请求数据Model")
public class CartRequest {

    @ApiModelProperty("会员Id")
    @NotNull(message = "会员Id为空")
    private Long memberId;

    @ApiModelProperty("状态 1--未删除 0--已删除")
    private Integer status;
}
