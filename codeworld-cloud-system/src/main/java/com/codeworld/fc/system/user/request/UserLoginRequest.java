package com.codeworld.fc.system.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * ClassName UserLoginRequest
 * Description 用户登录请求数据
 * Author Lenovo
 * Date 2020/8/12
 * Version 1.0
**/
@Data
@ApiModel("用户登录请求数据")
public class UserLoginRequest {

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名为空")
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "密码为空")
    private String password;

    @ApiModelProperty("Token验证")
    private String token;

}
