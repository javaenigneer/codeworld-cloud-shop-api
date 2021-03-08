package com.codeworld.fc.logistics.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName LogisticsSelectRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/5
 * Version 1.0
**/
@Data
public class LogisticsSelectRequest {

    /**
     * 物流单号
     */
    @NotNull(message = "物流单号为空")
    private String deliveryNumber;

    /**
     * 订单编号
     */
    @NotNull(message = "订单编号为空")
    private Long orderId;
}
