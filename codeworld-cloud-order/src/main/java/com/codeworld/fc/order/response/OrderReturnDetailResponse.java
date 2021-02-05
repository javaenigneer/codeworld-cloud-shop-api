package com.codeworld.fc.order.response;

import com.codeworld.fc.order.domain.ProductModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ClassName OrderReturnDetailResponse
 * Description 订单退款退货详情
 * Author Lenovo
 * Date 2021/2/1
 * Version 1.0
**/
@Data
@ApiModel("订单退款退货详情")
public class OrderReturnDetailResponse {

    @ApiModelProperty("订单编号")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderId;

    @ApiModelProperty("总金额")
    private Long totalPay;

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("会员名称")
    private String buyerName;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("地址Id")
    private Long addressId;

    @ApiModelProperty("收货人")
    private String receiverName;

    @ApiModelProperty("收货人手机")
    private String receiverPhone;

    @ApiModelProperty("收货地址")
    private String receiverAddress;

    @ApiModelProperty("商品信息")
    private List<ProductModel> productModels;

    @ApiModelProperty("物流公司")
    private String orderDeliveryCompany;

    @ApiModelProperty("订单物流单号")
    private String orderDeliveryNumber;

    @ApiModelProperty("订单售后编号")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderReturnId;

    @ApiModelProperty("订单退货退款状态")
    private Integer orderReturnStatus;

    @ApiModelProperty("订单退款退货申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnApplyTime;
}
