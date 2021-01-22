package com.codeworld.fc.auth.client.impl;

import com.codeworld.fc.auth.client.UserClient;
import com.codeworld.fc.auth.domain.User;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import org.springframework.stereotype.Component;

/**
 * ClassName UserClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class UserClientFallBack implements UserClient {
    @Override
    public FCResponse<User> getUserByName(String username) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
