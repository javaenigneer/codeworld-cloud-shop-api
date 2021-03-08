package com.codeworld.fc.store.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.store.request.StoreAddRequest;
import com.codeworld.fc.store.request.StoreSearchRequest;
import com.codeworld.fc.store.response.StorePageResponse;

import java.util.List;

/**
 * ClassName StoreService
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
**/
public interface StoreService {
    /**
     * 分页获取商户店铺列表
     * @param storeSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<StorePageResponse>>> getMerchantStoreByPage(StoreSearchRequest storeSearchRequest);

    /**
     * 新增店铺
     * @param storeAddRequest
     * @return
     */
    FCResponse<Void> createStore(StoreAddRequest storeAddRequest);
}
