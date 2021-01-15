package com.codeworld.fc.merchant.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Merchant
 * Description 商户Model
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@Data
@ApiModel("商户Model")
public class Merchant {

    @ApiModelProperty("商户Id")
    private Long id;

    @ApiModelProperty("商户号")
    private String number;

    @ApiModelProperty("商户昵称")
    private String nickName;

    @ApiModelProperty("商户手机号")
    private String phone;

    @ApiModelProperty("商户登录密码")
    private String password;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
