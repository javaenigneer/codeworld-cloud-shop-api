package com.codeworld.fc.order.domain;

import lombok.Data;

/**
 * ClassName CommodityStocks
 * Description 商品库存，主要用于用户下单锁定商品库存
 * Author Lenovo
 * Date 2021/3/2
 * Version 1.0
**/
@Data
public class CommodityStocks {

    /**
     * 商品SkuId
     */
    private Long productSkuId;

    /**
     * 锁定商品数量
     */
    private Integer lockedNumber;
}
