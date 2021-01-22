package com.codeworld.fc.search.client.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.client.CategoryClient;
import com.codeworld.fc.search.domain.Category;
import org.springframework.stereotype.Component;

/**
 * ClassName CategoryClientFallBack
 * Description TODO
 * Author Lenovo
 * Date 2021/1/20
 * Version 1.0
**/
@Component
public class CategoryClientFallBack implements CategoryClient {
    @Override
    public FCResponse<Category> getCategoryById(Long categoryId) {
        return FCResponse.dataResponse(HttpFcStatus.RUNTIMECODE.getCode(), "请求超时",null);
    }
}
