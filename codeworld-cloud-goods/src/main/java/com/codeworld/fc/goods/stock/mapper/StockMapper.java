package com.codeworld.fc.goods.stock.mapper;

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
}
