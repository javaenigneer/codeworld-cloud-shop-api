package com.codeworld.fc.store.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName StoreAddRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/8
 * Version 1.0
**/
@Data
public class StoreAddRequest {

    /**
     * 店铺名称
     */
    @NotNull(message = "请输入店铺名称")
    private String name;

    /**
     * 店铺状态
     */
    @NotNull(message = "请选择店铺状态")
    private Integer status;
}
