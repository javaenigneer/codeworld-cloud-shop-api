package com.codeworld.fc.order.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName OrderProcessingRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/2/24
 * Version 1.0
**/
@Data
public class OrderProcessingRequest {

    /**
     * 订单售后Id
     */
    @NotNull(message = "服务订单号为空")
    private Long orderReturnId;

    /**
     * 订单售后备注
     */
    private String remark;
}
