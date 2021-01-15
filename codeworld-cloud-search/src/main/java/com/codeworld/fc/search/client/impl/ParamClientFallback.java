package com.codeworld.fc.search.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.client.ParamClient;
import com.codeworld.fc.search.domain.ParamResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName ParamClientFallback
 * Description TODO
 * Author Lenovo
 * Date 2020/12/15
 * Version 1.0
**/
@Component
public class ParamClientFallback implements ParamClient {
    @Override
    public FCResponse<List<ParamResponse>> getParamByCategoryId(Long categoryId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请稍后再试",null);
    }
}
