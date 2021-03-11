package com.codeworld.fc.store.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName StoreCategoryAddRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/11
 * Version 1.0
**/
@Data
public class StoreCategoryAddRequest {

    /**
     * 店铺Id
     */
    @NotNull(message = "店铺Id为空")
    private Long storeId;

    /**
     * 上级Id
     */
    @NotNull(message = "上级Id为空")
    private Long parentId;

    /**
     * 分类名
     */
    @NotNull(message = "请输入分类名")
    private String name;

    /**
     * 排序
     */
    @NotNull(message = "请输入排序")
    private Integer sortNo;
}
