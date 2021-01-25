package com.codeworld.fc.order.response;

import com.codeworld.fc.order.domain.ProductModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName OrderDetailResponse
 * Description 订单详细信息Model
 * Author Lenovo
 * Date 2021/1/8
 * Version 1.0
**/
@Data
@ApiModel("订单详细信息Model")
public class OrderDetailResponse {

    @ApiModelProperty("订单编号")
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


}
