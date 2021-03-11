package com.codeworld.fc.store.response;

import lombok.Data;

/**
 * ClassName StoreResponse
 * Description TODO
 * Author Lenovo
 * Date 2021/3/10
 * Version 1.0
**/
@Data
public class StoreResponse {

    /**
     * 店铺Id
     */
    private Long id;

    /**
     * 店铺名称
     */
    private String name;
}
