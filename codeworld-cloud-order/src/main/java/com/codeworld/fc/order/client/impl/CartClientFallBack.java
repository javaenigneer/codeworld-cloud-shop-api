package com.codeworld.fc.order.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.client.CartClient;
import org.springframework.stereotype.Component;

/**
 * ClassName CartClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class CartClientFallBack implements CartClient {
    @Override
    public FCResponse<Void> deleteCartByIds(String cartIds) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
