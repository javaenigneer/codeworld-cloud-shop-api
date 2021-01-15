package com.codeworld.fc.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName PayOrderRequest
 * Description 订单支付信息Model
 * Author Lenovo
 * Date 2020/12/29
 * Version 1.0
**/
@Data
@ApiModel("订单支付信息Model")
public class PayOrderRequest {

    @ApiModelProperty("订单Id")
    @NotNull(message = "订单Id不能为空")
    private Long orderId;

    @ApiModelProperty("总金额")
    @NotNull(message = "总金额不能为空")
    private Long totalPay;
}
