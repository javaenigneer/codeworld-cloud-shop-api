package com.codeworld.fc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName OrderReturn
 * Description 订单退款退货
 * Author Lenovo
 * Date 2021/1/25
 * Version 1.0
**/
@Data
@ApiModel("订单退款退货")
public class OrderReturn {

    @ApiModelProperty("退货订单主键id")
    private Long orderReturnId;

    @ApiModelProperty("原订单id")
    private Long orderId;

    @ApiModelProperty("订单退货退款状态")
    private Integer orderReturnStatus;

    @ApiModelProperty("订单退款退货类型 1--退款 3--退货")
    private Integer orderReturnType;

    @ApiModelProperty("订单退货退款处理时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnHandleTime;

    @ApiModelProperty("退货原因")
    private String orderReturnReason;

    @ApiModelProperty("订单退款退货申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnApplyTime;

    @ApiModelProperty("订单退款退货备注")
    private String orderReturnRemark;
}
