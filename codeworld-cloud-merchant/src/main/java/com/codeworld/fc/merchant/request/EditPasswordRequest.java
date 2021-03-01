package com.codeworld.fc.merchant.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ClassName EditPasswordRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
**/
@Data
public class EditPasswordRequest {

    /**
     * 旧密码
     */
    @Size(min = 6,max = 10,message = "密码在6-10位")
    private String oldPassword;

    /**
     * 新密码
     */
    @Size(min = 6,max = 10,message = "密码在6-10位")
    private String newPassword;

    /**
     * 入驻手机号
     */
    @NotNull(message = "手机号为空")
    private String setPhone;
}
