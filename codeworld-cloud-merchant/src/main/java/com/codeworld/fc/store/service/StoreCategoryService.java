package com.codeworld.fc.store.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.store.request.StoreCategoryAddRequest;
import com.codeworld.fc.store.request.StoreCategoryEditRequest;

public interface StoreCategoryService {
    /**
     * 添加店铺分类
     * @param storeCategoryAddRequest
     * @return
     */
    FCResponse<Void> addStoreCategory(StoreCategoryAddRequest storeCategoryAddRequest);

    /**
     * 修改店铺分类
     * @param storeCategoryEditRequest
     * @return
     */
    FCResponse<Void> editStoreCategory(StoreCategoryEditRequest storeCategoryEditRequest);
}
