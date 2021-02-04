package com.codeworld.fc.order.response;

import com.codeworld.fc.order.domain.ProductModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ClassName OrderReturnResponse
 * Description 订单退款退货Response
 * Author Lenovo
 * Date 2021/2/1
 * Version 1.0
**/
@Data
@ApiModel("订单退款退货Response")
public class OrderReturnResponse {

    @ApiModelProperty("退货订单主键id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderReturnId;

    @ApiModelProperty("原订单id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderId;

    @ApiModelProperty("订单退货退款状态")
    private Integer orderReturnStatus;

    @ApiModelProperty("订单退货退款处理时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnHandleTime;

    @ApiModelProperty("退货原因")
    private String orderReturnReason;

    @ApiModelProperty("订单退款退货申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnApplyTime;

    @ApiModelProperty("服务订单类型 1--退款 3--退货")
    private Integer orderReturnType;

    @ApiModelProperty("订单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("订单总金额")
    private Long totalPay;

    @ApiModelProperty("订单实付金额")
    private Long actualPay;

    @ApiModelProperty("订单配送地址Id")
    private Long addressId;

    @ApiModelProperty("买家名称")
    private String buyerName;

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("商品数量")
    private Integer count;

    @ApiModelProperty("商品信息")
    private List<ProductModel> productModels;
}
