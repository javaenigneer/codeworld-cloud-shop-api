package com.codeworld.fc.goods.stock.service.impl;

import com.codeworld.fc.goods.stock.mapper.StockMapper;
import com.codeworld.fc.goods.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
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


}
