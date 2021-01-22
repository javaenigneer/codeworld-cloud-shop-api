package com.codeworld.fc.order.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName OrderStatusCount
 * Description 订单状态下的数量
 * Author Lenovo
 * Date 2021/1/21
 * Version 1.0
**/
@Data
@ApiModel("订单状态下的数量")
public class OrderStatusCount {

    @ApiModelProperty("待付款")
    private Integer pendingPaymentCount;

    @ApiModelProperty("待发货")
    private Integer toBeDeliveredCount;

    @ApiModelProperty("待收货")
    private Integer toBeReceivedCount;

    @ApiModelProperty("待评价")
    private Integer comment;

    @ApiModelProperty("已完成")
    private Integer completedCount;


}
