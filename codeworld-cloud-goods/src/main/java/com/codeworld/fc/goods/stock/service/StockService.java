package com.codeworld.fc.goods.stock.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.stock.domain.CommodityStocks;

/**
 * ClassName StockService
 * Description TODO
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
public interface StockService {
    /**
     * 更新库存（减掉库存）
     * @param commodityStocks
     * @return
     */
    FCResponse<Void> updateProductStockMinus(CommodityStocks commodityStocks);

    /**
     * 判断库存是否充足
     * @param commodityStocks
     * @return
     */
    FCResponse<Boolean> judgeStockAdequate(CommodityStocks commodityStocks);
}
