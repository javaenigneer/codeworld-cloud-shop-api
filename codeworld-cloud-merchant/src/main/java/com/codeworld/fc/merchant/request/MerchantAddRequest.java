package com.codeworld.fc.merchant.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName MerChantAddRequest
 * Description 商户入驻添加信息
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@Data
@ApiModel("商户入驻添加信息")
public class MerchantAddRequest {

    @ApiModelProperty("商家名称")
    @NotNull(message = "请输入商家名称")
    private String merchantName;

    @ApiModelProperty("身份证正面")
    @NotNull(message = "请上传身份证正面")
    private String idCardFront;

    @ApiModelProperty("身份证反面")
    @NotNull(message = "请上传身份证反面")
    private String idCardBack;

    @ApiModelProperty("营业执照")
    @NotNull(message = "请上传营业执照")
    private String license;

    @ApiModelProperty("入住类型 1--包月 2--包季 3--包年")
    @NotNull(message = "请选择入驻类型")
    private Integer type;
}
