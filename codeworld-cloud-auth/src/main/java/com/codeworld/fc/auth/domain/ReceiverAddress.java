package com.codeworld.fc.auth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName ReceiverAddress
 * Description 收货地址
 * Author Lenovo
 * Date 2020/12/23
 * Version 1.0
 **/
@Data
@ApiModel("收货地址")
public class ReceiverAddress {

    @ApiModelProperty("地址主键Id")
    private Long id;

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("收货人")
    private String name;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("收货区域")
    private String area;

    @ApiModelProperty("详细地址")
    private String detailed;

    @ApiModelProperty("门牌号")
    private String houseNumber;

    @ApiModelProperty("状态 1--默认，0--其他")
    private Integer status;
}
