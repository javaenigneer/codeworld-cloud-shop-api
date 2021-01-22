package com.codeworld.fc.auth.client.impl;

import com.codeworld.fc.auth.client.RoleClient;
import com.codeworld.fc.auth.domain.Role;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
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
    public FCResponse<Role> getRoleByUserId(Long userId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
