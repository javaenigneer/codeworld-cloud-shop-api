package com.codeworld.fc.common.domain;

import lombok.Data;

/**
 * ClassName InfoData
 * Description 登录信息Data
 * Author Lenovo
 * Date 2020/12/31
 * Version 1.0
**/
@Data
public class LoginInfoData {

    /**
     * id
     */
    private Long id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 对象数据
     */
    private String resources;

    public LoginInfoData(Long id, String phone, String resources) {
        this.id = id;
        this.phone = phone;
        this.resources = resources;
    }

    public LoginInfoData() {
    }

    public LoginInfoData(String resources) {
        this.resources = resources;
    }
}
