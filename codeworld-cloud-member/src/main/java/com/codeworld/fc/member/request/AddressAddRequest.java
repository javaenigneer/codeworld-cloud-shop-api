package com.codeworld.fc.member.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName AddressAddRequest
 * Description 地址Model
 * Author Lenovo
 * Date 2020/12/24
 * Version 1.0
**/
@Data
@ApiModel("地址Model")
public class AddressAddRequest {

    @ApiModelProperty("地址Id")
    private Long id;

    @ApiModelProperty("会员Id")
    @NotNull(message = "会员id不能为空")
    private Long memberId;

    @ApiModelProperty("收货人名称")
    @NotNull(message = "请输入收货人名称")
    private String name;

    @ApiModelProperty("收货人手机")
    @NotNull(message = "请输入收货人手机")
    private String phone;

    @ApiModelProperty("收货人区域")
    @NotNull(message = "请选择收货人区域")
    private String area;

    @ApiModelProperty("收货人详细地址")
    @NotNull(message = "请输入详细地址")
    private String detailed;

    @ApiModelProperty("收货人街道或门牌号")
    @NotNull(message = "请输入街道或门牌号")
    private String houseNumber;

    @ApiModelProperty("是否为默认地址")
    private Integer status;
}
