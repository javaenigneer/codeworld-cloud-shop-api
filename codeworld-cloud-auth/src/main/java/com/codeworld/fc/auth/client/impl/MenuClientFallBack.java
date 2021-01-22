package com.codeworld.fc.auth.client.impl;

import com.codeworld.fc.auth.client.MenuClient;
import com.codeworld.fc.auth.domain.Menu;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName MenuClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class MenuClientFallBack implements MenuClient {
    @Override
    public FCResponse<List<Menu>> getMenuByRoleId(Long roleId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
