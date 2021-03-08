package com.codeworld.fc.order.response;

import com.codeworld.fc.order.domain.ProductModel;
import com.codeworld.fc.order.domain.ProductSkuModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * ClassName OrderResponse
 * Description 订单信息Response
 * Author Lenovo
 * Date 2020/12/29
 * Version 1.0
**/
@Data
@ApiModel("订单信息Response")
public class OrderResponse {

    // 订单编号
    @ApiModelProperty("订单编号")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderId;

    @ApiModelProperty("订单明细编号")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long orderDetailId;

    @ApiModelProperty("订单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("订单总金额")
    private Long totalPay;

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

    @ApiModelProperty("订单退款退货状态")
    private Integer orderReturnStatus;

    @ApiModelProperty("订单退款退货申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date orderReturnApplyTime;

    @ApiModelProperty("物流单号")
    private String deliveryNumber;

}
