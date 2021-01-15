package com.codeworld.fc.merchant.domain;

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

    @ApiModelProperty("商户Id")
    private Long id;

    @ApiModelProperty("商户昵称")
    private String nickName;

    @ApiModelProperty("手机号")
    private String phone;

    public MerchantInfo(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public MerchantInfo() {
    }
}
