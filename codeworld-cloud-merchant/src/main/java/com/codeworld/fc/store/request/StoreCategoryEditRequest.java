package com.codeworld.fc.store.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName StoreCategoryEditRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/11
 * Version 1.0
**/
@Data
public class StoreCategoryEditRequest {

    /**
     * 店铺分类Id
     */
    @NotNull(message = "店铺分类Id为空")
    private Long id;

    /**
     * 分类名称
     */
    @NotNull(message = "请输入分类名称")
    private String name;

    /**
     * 排序
     */
    @NotNull(message = "请输入排序")
    private Integer sortNo;

}
