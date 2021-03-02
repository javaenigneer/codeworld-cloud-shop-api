package com.codeworld.fc.order.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.CommodityStocks;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "codeworld-cloud-goods")
public interface StockClient {

    @PostMapping("/codeworld-goods/stock/judgeStockAdequate")
    @ApiOperation("判断库存是否充足")
    FCResponse<Boolean> judgeStockAdequate(@RequestBody CommodityStocks commodityStocks);

    @PostMapping("/codeworld-goods/stock/update-product-stock-minus")
    @ApiOperation("更新库存（减掉）")
    FCResponse<Void> updateProductStockMinus(@RequestBody CommodityStocks commodityStocks);
}
