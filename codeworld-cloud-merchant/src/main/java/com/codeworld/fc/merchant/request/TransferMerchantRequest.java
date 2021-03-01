package com.codeworld.fc.merchant.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName TransferMerchantRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/2/26
 * Version 1.0
**/
@Data
public class TransferMerchantRequest {

    /**
     * 商户号
     */
    @NotNull(message = "商户号为空")
    private String merchantNumber;

    /**
     * 用户id
     */
    @NotNull(message = "用户id为空")
    private Long userId;
}
