package com.codeworld.fc.merchant.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName MerchantWxInfo
 * Description 商户微信信息
 * Author Lenovo
 * Date 2021/3/19
 * Version 1.0
**/
@Data
@ApiModel("商户微信信息")
public class MerchantWxInfo {

    @ApiModelProperty("商户号")
    private String merchantNumber;

    @ApiModelProperty("商户OpenId")
    private String openId;


}

