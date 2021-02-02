package com.codeworld.fc.merchant.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ClassName MerchantRegisterRequest
 * Description 商户注册Request
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
 **/
@Data
@ApiModel("app端商户注册Request")
public class MerchantRegisterRequestApp {

    @ApiModelProperty("昵称")
    @Size(min = 4, max = 10, message = "昵称在4-10位")
    private String nickName;

    @ApiModelProperty("手机号")
    @NotNull(message = "请输入手机号")
    private String phone;

    @ApiModelProperty("密码")
    @Size(min = 6, max = 12, message = "密码在6-12位")
    private String password;

    @ApiModelProperty("验证码")
    @NotNull(message = "请输入验证码")
    private String code;

    @ApiModelProperty("商户跟进人")
    private Long merchantFollowUser;
}
