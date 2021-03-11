package com.codeworld.fc.store.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.store.request.StoreCategoryAddRequest;

public interface StoreCategoryService {
    /**
     * 添加店铺分类
     * @param storeCategoryAddRequest
     * @return
     */
    FCResponse<Void> addStoreCategory(StoreCategoryAddRequest storeCategoryAddRequest);
}
