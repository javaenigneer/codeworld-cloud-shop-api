package com.codeworld.fc.order.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.client.MerchantClient;
import com.codeworld.fc.order.domain.MerchantResponse;
import org.springframework.stereotype.Component;

/**
 * ClassName MerchantClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class MerchantClientFallBack implements MerchantClient {
    @Override
    public FCResponse<MerchantResponse> getMerchantNumberAndNameById(Long merchantId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
