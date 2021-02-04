package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName OrderAddAsyn
 * Description 订单异步添加Domain
 * Author Lenovo
 * Date 2021/2/3
 * Version 1.0
**/
@Data
public class OrderAddAsyn {


    /**
     * 地址Id
     */
    private Long addressId;

    /**
     * 订单总金额
     */
    private Long payTotal;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 会员id
     */
    private Long memberId;
}
