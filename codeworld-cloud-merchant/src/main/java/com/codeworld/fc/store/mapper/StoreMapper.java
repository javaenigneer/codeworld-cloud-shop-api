package com.codeworld.fc.store.mapper;

import com.codeworld.fc.store.entity.Store;
import com.codeworld.fc.store.request.StoreSearchRequest;
import com.codeworld.fc.store.response.StorePageResponse;
import com.codeworld.fc.store.response.StoreResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StoreMapper {
    /**
     * 查询商户下的店铺列表
     * @param storeSearchRequest
     * @return
     */
    List<StorePageResponse> getMerchantStoreByPage(StoreSearchRequest storeSearchRequest);

    /**
     * 新增店铺
     * @param store
     */
    void createStore(Store store);

    /**
     * 根据店铺名模糊查询
     * @param map
     * @return
     */
    List<StoreResponse> getStoreByName(Map<String, Object> map);
}
