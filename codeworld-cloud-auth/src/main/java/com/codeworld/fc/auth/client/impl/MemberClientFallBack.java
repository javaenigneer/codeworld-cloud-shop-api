package com.codeworld.fc.auth.client.impl;

import com.codeworld.fc.auth.client.MemberClient;
import com.codeworld.fc.auth.domain.MemberReceiverAddressInfo;
import com.codeworld.fc.auth.domain.MemberResponse;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
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
    public FCResponse<Integer> checkMemberByPhone(String phone) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MemberResponse> getMemberByPhone(String phone) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }

    @Override
    public FCResponse<MemberReceiverAddressInfo> getMemberReceiverAddressByMemberId(Long memberId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
