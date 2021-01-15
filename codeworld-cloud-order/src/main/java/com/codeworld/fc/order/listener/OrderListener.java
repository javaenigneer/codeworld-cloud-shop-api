package com.codeworld.fc.order.listener;

import com.codeworld.fc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName OrderListener
 * Description 订单MQ监听器
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@Component
public class OrderListener {

    @Autowired(required = false)
    private OrderService orderService;


}
