package com.codeworld.fc.collection.response;

import lombok.Data;

/**
 * ClassName CollectionResponse
 * Description TODO
 * Author Lenovo
 * Date 2021/3/9
 * Version 1.0
**/
@Data
public class CollectionResponse {

    /**
     * 收藏Id
     */
    private Long id;

    /**
     * 商品Id
     */
    private Long productId;

    /**
     * 商品SkuId
     */
    private Long productSkuId;

    /**
     * 商品图片
     */
    private String productImage;

    /**
     * 商品单价
     */
    private Integer productPrice;
}
