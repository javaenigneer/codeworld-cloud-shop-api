package com.codeworld.fc.goods.stock.service.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.stock.domain.CommodityStocks;
import com.codeworld.fc.goods.stock.mapper.StockMapper;
import com.codeworld.fc.goods.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName StockServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
 **/
@Service
@Slf4j
public class StockServiceImpl implements StockService {

    @Autowired(required = false)
    private StockMapper stockMapper;


    /**
     * 更新库存（减掉库存）
     *
     * @param commodityStocks
     * @return
     */
    @Override
    public FCResponse<Void> updateProductStockMinus(CommodityStocks commodityStocks) {
        if (ObjectUtils.isEmpty(commodityStocks) || ObjectUtils.isEmpty(commodityStocks.getProductSkuId()) || commodityStocks.getProductSkuId() <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.product.PRODUCT_ID_ERROR.getMsg());
        }
        try {
            this.stockMapper.updateProductStockMinus(commodityStocks);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.stock.STOCK_UPDATE_SUCCESS.getMsg());
        } catch (Exception e) {
            throw new FCException("系统错误");
        }
    }

    /**
     * 判断库存是否充足
     *
     * @param commodityStocks
     * @return
     */
    @Override
    public FCResponse<Boolean> judgeStockAdequate(CommodityStocks commodityStocks) {
        if (ObjectUtils.isEmpty(commodityStocks) || ObjectUtils.isEmpty(commodityStocks.getProductSkuId()) || commodityStocks.getProductSkuId() <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.product.PRODUCT_ID_ERROR.getMsg());
        }
        try {
            // 查询商品库存
            Integer count = this.stockMapper.getStockByProductSkuId(commodityStocks.getProductSkuId());
            // 库存数量不足
            if (commodityStocks.getLockedNumber() >= count){
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.stock.STOCK_COUNT_INSUFFICIENT.getMsg(),false);
            }
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.stock.STOCK_COUNT_ADEQUATE.getMsg(),true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
