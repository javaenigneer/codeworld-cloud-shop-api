package com.codeworld.fc.store.mapper;

import com.codeworld.fc.store.entity.StoreCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StoreCategoryMapper {


    /**
     * 根据店铺id获取店铺分类
     * @param map
     * @return
     */
    List<StoreCategory> getStoreCategoryByStoreId(Map<String, Object> map);
}
