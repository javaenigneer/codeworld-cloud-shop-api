package com.codeworld.fc.order.response;

import com.codeworld.fc.order.domain.ProductModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * ClassName OrderPageResponse
 * Description 系统订单展示列表
 * Author Lenovo
 * Date 2021/1/8
 * Version 1.0
**/
@Data
@ApiModel("系统订单展示列表")
public class OrderPageResponse {

    // 订单编号
    @ApiModelProperty("订单编号")
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
}
