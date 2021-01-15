package com.codeworld.fc.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName TokenRequest
 * Description token信息
 * Author Lenovo
 * Date 2020/12/23
 * Version 1.0
**/
@Data
@ApiModel("token信息")
public class TokenRequest {

    @ApiModelProperty("token信息")
    @NotNull(message = "身份已过期，请重新登录")
    private String token;
}
