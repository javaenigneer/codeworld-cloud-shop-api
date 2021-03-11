package com.codeworld.fc.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.client.RoleClient;
import com.codeworld.fc.merchant.domain.UserRole;
import org.springframework.stereotype.Component;

/**
 * ClassName RoleClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class RoleClientFallBack implements RoleClient {
    @Override
    public FCResponse<Void> addUserRole(UserRole userRole) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
