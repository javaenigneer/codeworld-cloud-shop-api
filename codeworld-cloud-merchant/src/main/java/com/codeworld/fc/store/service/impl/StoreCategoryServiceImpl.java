package com.codeworld.fc.store.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.store.entity.StoreCategory;
import com.codeworld.fc.store.mapper.StoreCategoryMapper;
import com.codeworld.fc.store.request.StoreCategoryAddRequest;
import com.codeworld.fc.store.service.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName StoreCategoryServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/3/11
 * Version 1.0
**/
@Service
public class StoreCategoryServiceImpl implements StoreCategoryService {

    @Autowired(required = false)
    private StoreCategoryMapper storeCategoryMapper;

    /**
     * 添加店铺分类
     *
     * @param storeCategoryAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> addStoreCategory(StoreCategoryAddRequest storeCategoryAddRequest) {
        StoreCategory storeCategory = new StoreCategory();
        BeanUtil.copyProperties(storeCategoryAddRequest,storeCategory);
        storeCategory.setId(IDGeneratorUtil.getNextId());
        storeCategory.setCreateTime(new Date());
        storeCategory.setUpdateTime(storeCategory.getCreateTime());
        try {
            this.storeCategoryMapper.addStoreCategory(storeCategory);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.storeCategory.STORE_CATEGORY_ADD_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
