package com.codeworld.fc.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName OrderEvaluation
 * Description TODO
 * Author Lenovo
 * Date 2021/2/20
 * Version 1.0
**/
@Data
@ApiModel("订单评价")
public class OrderEvaluation {

    @ApiModelProperty("订单详情id")
    private Long orderDetailId;

    @ApiModelProperty("订单商品评价内容")
    private String evaluationContent;

    @ApiModelProperty("订单商品评价图片")
    private String evaluationImage;

    @ApiModelProperty("评分")
    private Integer evaluationRate;

    @ApiModelProperty("评价时间")
    private Date evaluationTime;
}
