package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Logistics
 * Description TODO
 * Author Lenovo
 * Date 2021/3/3
 * Version 1.0
**/
@Data
@ApiModel("异步通知物流发货Model")
public class Logistics {

    @ApiModelProperty("物流主键Id")
    private Long id;

    @ApiModelProperty("物流单号")
    private String deliveryNumber;

    @ApiModelProperty("物流编号")
    private Integer deliverySn;

    @ApiModelProperty("订单号")
    private Long orderId;

    @ApiModelProperty("物流到达时间")
    private Date arriveTime;

    @ApiModelProperty("物流更新内容")
    private String content;
}
