package com.codeworld.fc.auth.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName MerchantInfo
 * Description 商户信息
 * Author Lenovo
 * Date 2020/12/31
 * Version 1.0
**/
@Data
@ApiModel("商户信息")
public class MerchantInfo {

    @ApiModelProperty("商户id")
    private Long id;

    @ApiModelProperty("商户昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("商户号")
    private String number;

    @ApiModelProperty("商户名称")
    private String merchantName;

}
