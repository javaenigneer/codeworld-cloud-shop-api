package com.codeworld.fc.goods.stock.mapper;

import com.codeworld.fc.goods.stock.domain.CommodityStocks;
import com.codeworld.fc.goods.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockMapper {
    /**
     * 库存信息添加
     * @param stock
     */
    void addStock(Stock stock);

    /**
     * 更新库存（删减）
     * @param commodityStocks
     */
    void updateProductStockMinus(CommodityStocks commodityStocks);

    /**
     * 查询商品库存
     * @param productSkuId
     * @return
     */
    Integer getStockByProductSkuId(Long productSkuId);
}
