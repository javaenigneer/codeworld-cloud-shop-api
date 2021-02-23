package com.codeworld.fc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName OrderStatus
 * Description 订单状态Model
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@Data
@ApiModel("订单状态Model")
public class OrderStatus {

    @ApiModelProperty("订单Id")
    private Long orderId;

    /**
     * 订单状态 1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价 7、失效订单
     * 8、售后服务 9、未评价
     */
    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date payTime;

    @ApiModelProperty("发货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date consignTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty("关闭时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date closeTime;
}
