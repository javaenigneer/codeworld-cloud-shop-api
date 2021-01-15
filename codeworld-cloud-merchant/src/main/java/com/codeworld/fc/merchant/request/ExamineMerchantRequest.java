package com.codeworld.fc.merchant.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName ExamineMerchantRequest
 * Description 商户审核Request
 * Author Lenovo
 * Date 2021/1/5
 * Version 1.0
**/
@Data
public class ExamineMerchantRequest {

    @NotNull(message = "请输入商户号")
    private String number;

    @NotNull(message = "请选择状态")
    private Integer status;
}
