package com.codeworld.fc.merchant.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName MerchantPageResponse
 * Description 商户列表信息Response
 * Author Lenovo
 * Date 2021/1/4
 * Version 1.0
**/
@Data
@ApiModel("商户列表信息Response")
public class MerchantPageResponse {

    @ApiModelProperty("商户Id")
    private Long merchantId;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("商户手机号")
    private String merchantPhone;
}
