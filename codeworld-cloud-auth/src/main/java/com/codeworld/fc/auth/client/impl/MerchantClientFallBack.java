package com.codeworld.fc.auth.client.impl;

import com.codeworld.fc.auth.client.MerchantClient;
import com.codeworld.fc.auth.domain.MerchantResponse;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
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
    public FCResponse<Integer> checkMerchantByPhone(String phone) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MerchantResponse> getMerchantByPhone(String phone) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<Integer> checkMerchantByMerchantNumber(String merchantNumber) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MerchantResponse> getMerchantByMerchantNumber(String merchantNumber) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MerchantResponse> getMerchantInfoById(Long merchantId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MerchantResponse> getMerchantByOpenId(String openId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
