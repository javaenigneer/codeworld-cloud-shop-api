package com.codeworld.fc.goods.stock.controller;

import com.codeworld.fc.goods.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName StockController
 * Description 商品库存管理接口
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-goods/stock")
public class StockController {

    @Autowired(required = false)
    private StockService stockService;
}
