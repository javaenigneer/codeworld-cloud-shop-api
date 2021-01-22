package com.codeworld.fc.goods.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.client.SearchClient;
import org.springframework.stereotype.Component;

/**
 * ClassName SearchClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class SearchClientFallBack implements SearchClient {
    @Override
    public FCResponse<Void> importGoodsToElasticSearchTime() {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(),"请求超时",null);
    }
}
