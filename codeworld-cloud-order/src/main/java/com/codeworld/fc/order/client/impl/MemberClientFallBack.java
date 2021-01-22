package com.codeworld.fc.order.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.client.MemberClient;
import com.codeworld.fc.order.domain.MemberInfo;
import com.codeworld.fc.order.domain.ReceiverAddress;
import org.springframework.stereotype.Component;

/**
 * ClassName MemberClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class MemberClientFallBack implements MemberClient {
    @Override
    public FCResponse<MemberInfo> getMemberById(Long memberId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<ReceiverAddress> getReceiverAddressByAddressId(Long addressId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
