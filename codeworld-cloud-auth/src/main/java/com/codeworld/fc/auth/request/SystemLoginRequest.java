package com.codeworld.fc.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName SystemLoginRequest
 * Description 系统后台登录
 * Author Lenovo
 * Date 2021/1/5
 * Version 1.0
**/
@Data
@ApiModel("系统后台登录")
public class SystemLoginRequest {

    @ApiModelProperty("登录用户")
    @NotNull(message = "请输入用户名")
    private String username;

    @ApiModelProperty("登录密码")
    @NotNull(message = "密码为空")
    private String password;
}
