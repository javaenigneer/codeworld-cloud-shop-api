package com.codeworld.fc.collection.service.impl;

import com.codeworld.fc.collection.entity.Collection;
import com.codeworld.fc.collection.mapper.CollectionMapper;
import com.codeworld.fc.collection.request.CollectionRequest;
import com.codeworld.fc.collection.response.CollectionResponse;
import com.codeworld.fc.collection.service.CollectionService;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.interceptor.AuthInterceptor;
import com.codeworld.fc.member.entity.Member;
import com.codeworld.fc.member.mapper.MemberMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName CollectionServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/3/8
 * Version 1.0
 **/
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired(required = false)
    private CollectionMapper collectionMapper;
    @Autowired(required = false)
    private MemberMapper memberMapper;

    /**
     * 收藏商品
     *
     * @param collectionRequest
     * @return
     */
    @Override
    public FCResponse<Void> collectionProduct(CollectionRequest collectionRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)) {
            throw new FCException("系统错误");
        }
        Member member = this.memberMapper.getMemberById(loginInfoData.getId());
        if (ObjectUtils.isEmpty(member)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.member.MEMBER_DATA_EMPTY.getMsg());
        }
        Collection collection = new Collection();
        collection.setId(IDGeneratorUtil.getNextId());
        collection.setMemberId(member.getId());
        collection.setProductId(collectionRequest.getProductId());
        collection.setProductSkuId(collectionRequest.getSkuId());
        collection.setImage(collectionRequest.getImage());
        collection.setPrice(collectionRequest.getPrice());
        collection.setTitle(collectionRequest.getTitle());
        collection.setCollectionTime(new Date());
        try {
            this.collectionMapper.collectionProduct(collection);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.collection.COLLECTION_PRODUCT__SUCCESS.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取会员商品收藏列表
     *
     * @return
     */
    @Override
    public FCResponse<List<CollectionResponse>> getMemberCollectionByPage() {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效");
        }
        // 根据会员Id获取会员收藏列表
        Long memberId = loginInfoData.getId();
        List<CollectionResponse> collectionResponses = this.collectionMapper.getMemberCollectionByPage(memberId);
        if (CollectionUtils.isEmpty(collectionResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.collection.COLLECTION_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.collection.COLLECTION_DATA_SUCCESS.getMsg(),collectionResponses);
    }
}
