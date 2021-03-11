package com.codeworld.fc.store.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.interceptor.AuthInterceptor;
import com.codeworld.fc.merchant.mapper.MerchantMapper;
import com.codeworld.fc.merchant.response.MerchantResponse;
import com.codeworld.fc.store.domain.StoreCategoryTreeNode;
import com.codeworld.fc.store.domain.TreeBuilder;
import com.codeworld.fc.store.entity.Store;
import com.codeworld.fc.store.entity.StoreCategory;
import com.codeworld.fc.store.mapper.StoreCategoryMapper;
import com.codeworld.fc.store.request.StoreAddRequest;
import com.codeworld.fc.store.request.StoreSearchRequest;
import com.codeworld.fc.store.response.StorePageResponse;
import com.codeworld.fc.store.response.StoreResponse;
import com.codeworld.fc.store.service.StoreService;
import com.codeworld.fc.store.mapper.StoreMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName StoreServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
 **/
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired(required = false)
    private StoreMapper storeMapper;
    @Autowired(required = false)
    private StoreCategoryMapper storeCategoryMapper;
    @Autowired(required = false)
    private MerchantMapper merchantMapper;


    /**
     * 分页获取商户店铺列表
     *
     * @param storeSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<StorePageResponse>>> getMerchantStoreByPage(StoreSearchRequest storeSearchRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMerchant();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效，请重新登录");
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantInfoById(loginInfoData.getId());
        if (ObjectUtils.isEmpty(merchantResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg());
        }
        storeSearchRequest.setMerchantNumber(merchantResponse.getNumber());
        List<StorePageResponse> storePageResponses = this.storeMapper.getMerchantStoreByPage(storeSearchRequest);
        if (CollectionUtils.isEmpty(storePageResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.store.STORE_DATA_EMPTY.getMsg(), DataResponse.dataResponse(null, 0L));
        }
        PageHelper.startPage(storeSearchRequest.getPage(), storeSearchRequest.getLimit());
        PageInfo<StorePageResponse> pageInfo = new PageInfo<>(storePageResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.store.STORE_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 新增店铺
     *
     * @param storeAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> createStore(StoreAddRequest storeAddRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMerchant();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("登录失效");
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantInfoById(loginInfoData.getId());
        if (ObjectUtils.isEmpty(merchantResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg());
        }
        Store store = new Store();
        BeanUtil.copyProperties(storeAddRequest, store);
        store.setId(IDGeneratorUtil.getNextId());
        store.setCreateTime(new Date());
        store.setMerchantNumber(merchantResponse.getNumber());
        store.setUpdateTime(store.getCreateTime());
        try {
            this.storeMapper.createStore(store);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.store.STORE_ADD_SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 根据店铺名称远程获取
     *
     * @param name
     * @return
     */
    @Override
    public FCResponse<List<StoreResponse>> getStoreByName(String name) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMerchant();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效，请重新登录");
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantInfoById(loginInfoData.getId());
        if (ObjectUtils.isEmpty(merchantResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg());
        }
        if (ObjectUtils.isEmpty(name)){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.store.STORE_NAME_ERROR.getMsg());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("merchantNumber",merchantResponse.getNumber());
        map.put("name",name);
        List<StoreResponse> storeResponses = this.storeMapper.getStoreByName(map);
        if (CollectionUtils.isEmpty(storeResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.store.STORE_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.store.STORE_DATA_SUCCESS.getMsg(),storeResponses);
    }

    /**
     * 根据店铺id获取店铺分类
     *
     * @param storeId
     * @return
     */
    @Override
    public FCResponse<List<StoreCategoryTreeNode>> getStoreCategoryByStoreId(Long storeId) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMerchant();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效，请重新登录");
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantInfoById(loginInfoData.getId());
        if (ObjectUtils.isEmpty(merchantResponse)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg());
        }
        if (ObjectUtils.isEmpty(storeId) || storeId <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.store.STORE_ID_ERROR.getMsg());
        }
        // 根据店铺Id查询全部的店铺分类
        Map<String, Object> map = new HashMap<>();
        map.put("storeId",storeId);
        map.put("merchantNumber",merchantResponse.getNumber());
        List<StoreCategory> storeCategories = this.storeCategoryMapper.getStoreCategoryByStoreId(map);
        if (CollectionUtils.isEmpty(storeCategories)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.storeCategory.STORE_CATEGORY_DATA_EMPTY.getMsg());
        }
        final List<StoreCategoryTreeNode> storeCategoryTreeNodes = Lists.newArrayList();
        storeCategories.forEach(storeCategory -> {
            StoreCategoryTreeNode storeCategoryTreeNode = new StoreCategoryTreeNode();
            BeanUtil.copyProperties(storeCategory,storeCategoryTreeNode);
            storeCategoryTreeNodes.add(storeCategoryTreeNode);
        });
        List<StoreCategoryTreeNode> newStoreCategoryTreeNodes = TreeBuilder.buildStoreCategoryTree(storeCategoryTreeNodes);
        newStoreCategoryTreeNodes.stream().sorted(Comparator.comparing(StoreCategoryTreeNode::getSortNo)).collect(Collectors.toList());
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.storeCategory.STORE_CATEGORY_DATA_SUCCESS.getMsg(),newStoreCategoryTreeNodes);
    }
}
