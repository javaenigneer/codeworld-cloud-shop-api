package com.codeworld.fc.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import javax.validation.constraints.NotNull;

/**
 * ClassName OrderReturnRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/2/23
 * Version 1.0
**/
@Data
@ApiModel("订单退货Model")
public class OrderReturnRequest {

    @ApiModelProperty("订单详情Id")
    @NotNull(message = "订单Id为空")
    private Long orderDetailId;

    @ApiModelProperty("退货原因")
    @NotNull(message = "退货原因为空")
    private String reason;
}
