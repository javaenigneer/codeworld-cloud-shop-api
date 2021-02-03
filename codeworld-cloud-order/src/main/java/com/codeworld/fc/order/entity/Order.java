package com.codeworld.fc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Order
 * Description 订单Model
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@Data
@ApiModel("订单Model")
public class Order {

    @ApiModelProperty("订单Id")
    private Long Id;

    @ApiModelProperty("订单总金额")
    private Long totalPay;

    @ApiModelProperty("订单实付金额")
    private Long actualPay;

    @ApiModelProperty("订单支付类型")
    private Integer payType;

    @ApiModelProperty("邮费")
    private Long postFee;

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("地址Id")
    private Long addressId;

    @ApiModelProperty("买家备注")
    private String buyerRemarks;

    @ApiModelProperty("买家会员名")
    private String buyerName;

    @ApiModelProperty("商户号")
    private String merchantNumber;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("订单物流公司")
    private String orderDeliveryCompany;

    @ApiModelProperty("订单物流编号")
    private Integer orderDeliverySn;

    @ApiModelProperty("订单物流单号")
    private String orderDeliveryNumber;

    @ApiModelProperty("订单下总共的商品数量")
    private Integer orderProductCount;

}
