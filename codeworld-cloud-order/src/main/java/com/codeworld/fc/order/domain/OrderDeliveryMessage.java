package com.codeworld.fc.order.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName OrderDeliveryMessage
 * Description 订单发货信息
 * Author Lenovo
 * Date 2021/1/25
 * Version 1.0
**/
@Data
public class OrderDeliveryMessage {

    @NotNull(message = "订单Id为空")
    private Long orderId;

    @NotNull(message = "物流公司为空")
    private Integer logisticsCompany;
}
