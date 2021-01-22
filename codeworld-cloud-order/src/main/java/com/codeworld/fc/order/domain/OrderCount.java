package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName OrderCount
 * Description 订单数量
 * Author Lenovo
 * Date 2021/1/21
 * Version 1.0
**/
@Data
@ApiModel("订单数量")
public class OrderCount {

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    @ApiModelProperty("订单数量")
    private Integer orderCount;

}
