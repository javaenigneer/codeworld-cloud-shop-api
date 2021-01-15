package com.codeworld.fc.member.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ClassName MemberRegisterRequest
 * Description 会员注册信息
 * Author Lenovo
 * Date 2020/12/18
 * Version 1.0
**/
@Data
@ApiModel("会员注册信息")
public class MemberRegisterRequest {

    @ApiModelProperty("手机号")
    @NotNull(message = "请输入手机号")
    private String phone;

    @ApiModelProperty("验证码")
    @NotNull(message = "请输入验证码")
    private String verifyCode;

    @ApiModelProperty("密码")
    @Size(min = 6, max = 10,message = "密码在6-10之间")
    private String password;
}
