package com.codeworld.fc.auth.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName MemberResponse
 * Description 会员Response
 * Author Lenovo
 * Date 2020/12/22
 * Version 1.0
**/
@Data
@ApiModel("会员Response")
public class MemberResponse {

    @ApiModelProperty("会员id")
    private Long id;

    @ApiModelProperty("会员名称")
    private String name;

    @ApiModelProperty("会员密码")
    private String password;

    @ApiModelProperty("手机号")
    private String phone;


}
