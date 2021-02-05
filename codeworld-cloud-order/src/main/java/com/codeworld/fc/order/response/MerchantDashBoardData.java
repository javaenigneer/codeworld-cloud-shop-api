package com.codeworld.fc.order.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName MerchantDashBoardData
 * Description 商户dashBoard显示数据
 * Author Lenovo
 * Date 2021/2/5
 * Version 1.0
**/
@Data
@ApiModel("商户dashBoard显示数据")
public class MerchantDashBoardData {

    @ApiModelProperty("订单总数")
    private Integer orderTotalCount;

    @ApiModelProperty("待付款")
    private Integer pendingPaymentCount;

    @ApiModelProperty("待发货")
    private Integer toBeDeliveredCount;

    @ApiModelProperty("已发货")
    private Integer shippedCount;

    @ApiModelProperty("已收货")
    private Integer receivedCount;

    @ApiModelProperty("退款中")
    private Integer refundingCount;

    @ApiModelProperty("待售后")
    private Integer afterSaleCount;

}
