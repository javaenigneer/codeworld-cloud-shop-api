package com.codeworld.fc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName OrderDetail
 * Description 订单详细Model
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@Data
@ApiModel("订单详细Model")
public class OrderDetail {

    @ApiModelProperty("订单详细Id")
    private Long detailId;

    @ApiModelProperty("订单Id")
    private Long orderId;

    @ApiModelProperty("商品SkuId")
    private Long productSkuId;

    @ApiModelProperty("商品数量")
    private Integer productCount;

    @ApiModelProperty("商品标题")
    private String productTitle;

    @ApiModelProperty("商品Sku详情")
    private String productSkuDetail;

    @ApiModelProperty("商品价格")
    private Long productPrice;

    @ApiModelProperty("商品图片")
    private String productImage;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("商户号")
    private String merchantNumber;

    @ApiModelProperty("订单物流公司")
    private String orderDeliveryCompany;

    @ApiModelProperty("订单物流编号")
    private Integer orderDeliverySn;

    @ApiModelProperty("订单物流单号")
    private String orderDeliveryNumber;

}
