package com.codeworld.fc.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ClassName MemberLoginRequest
 * Description 会员登录Request
 * Author Lenovo
 * Date 2020/12/22
 * Version 1.0
**/
@Data
@ApiModel("会员登录Request")
public class MemberLoginRequest {

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号为空")
    private String phone;

    @ApiModelProperty("密码")
    @Size(min = 6,max = 10,message = "密码长度在6-10位")
    private String password;
}
