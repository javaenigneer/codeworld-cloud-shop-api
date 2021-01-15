package com.codeworld.fc.auth.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName UserInfo
 * Description 用户基本信息Model
 * Author Lenovo
 * Date 2021/1/5
 * Version 1.0
**/
@Data
@ApiModel("用户基本信息Model")
public class UserInfo {

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("用户手机号")
    private String phone;


}
