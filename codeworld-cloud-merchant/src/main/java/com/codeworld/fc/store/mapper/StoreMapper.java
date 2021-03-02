package com.codeworld.fc.store.mapper;

import com.codeworld.fc.store.request.StoreSearchRequest;
import com.codeworld.fc.store.response.StorePageResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper {
    /**
     * 查询商户下的店铺列表
     * @param storeSearchRequest
     * @return
     */
    List<StorePageResponse> getMerchantStoreByPage(StoreSearchRequest storeSearchRequest);
}
