package com.codeworld.fc.order.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName OrderSearchRequest
 * Description 订单查询Model
 * Author Lenovo
 * Date 2020/12/29
 * Version 1.0
**/
@Data
@ApiModel("订单查询Model")
public class OrderSearchRequest extends PageQuery {

    @ApiModelProperty("订单状态")
    private Integer orderStatus;
    @ApiModelProperty("订单号")
    private Long orderId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("商户号")
    private String merchantNumber;
}
