package com.codeworld.fc.search.domain;

import lombok.Data;

/**
 * ClassName ElProductStatusDTO
 * Description 用于更新ElasticSearch商品状态传输Model
 * Author Lenovo
 * Date 2021/3/12
 * Version 1.0
**/
@Data
public class ElProductStatusDTO {

    /**
     * 商品Id
     */
    private Long productId;

    /**
     * 商品上架、下架 1--上架 0--下架
     */
    private Integer saleAble;
}
