package com.codeworld.fc.collection.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * ClassName CollectionRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/9
 * Version 1.0
**/
@Data
public class CollectionRequest {

    /**
     * 商品Id
     */
    @NotNull(message = "商品Id为空")
    private Long productId;

    /**
     * 商品skuId
     */
    @NotNull(message = "商品SkuId为空")
    private Long skuId;

    /**
     * 商品图片
     */
    @NotNull(message = "商品图片为空")
    private String image;

    /**
     * 商品单价
     */
    @NotNull(message = "商品单价为空")
    private Integer price;

    /**
     * 商品标题
     */
    @NotNull(message = "商品标题为空")
    private String title;
}
