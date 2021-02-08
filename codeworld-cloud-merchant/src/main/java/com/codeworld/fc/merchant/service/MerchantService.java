package com.codeworld.fc.merchant.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.merchant.request.*;
import com.codeworld.fc.merchant.response.MerchantResponse;

import java.util.List;

public interface MerchantService {
    /**
     * 商家入驻
     * @param merchantAddRequest
     * @return
     */
    FCResponse<Void> merchantSettled(MerchantAddRequest merchantAddRequest);

    /**
     * 商户注册
     * @param merchantRegisterRequest
     * @return
     */
    FCResponse<String> registerMerchantWeb(MerchantRegisterRequest merchantRegisterRequest);

    /**
     * 根据手机号判断是否被注册
     * @param phone
     * @return
     */
    FCResponse<Integer> checkMerchantByPhone(String phone);

    /**
     * 根据手机号获取商户信息
     * @param phone
     * @return
     */
    FCResponse<MerchantResponse> getMerchantByPhone(String phone);

    /**
     * 分页查询商户
     * @param merchantSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<MerchantResponse>>> getPageMerchant(MerchantSearchRequest merchantSearchRequest);

    /**
     * 根据商户号判断该商户是否存在
     * @param merchantNumber
     * @return
     */
    FCResponse<Integer> checkMerchantByMerchantNumber(String merchantNumber);

    /**
     * 根据商户号获取商户
     * @param merchantNumber
     * @return
     */
    FCResponse<MerchantResponse> getMerchantByMerchantNumber(String merchantNumber);

    /**
     * 审核商户
     * @param examineMerchantRequest
     * @return
     */
    FCResponse<Void> examineMerchant(ExamineMerchantRequest examineMerchantRequest);

    /**
     * 根据商户id获取商户信息
     * @param merchantId
     * @return
     */
    FCResponse<MerchantResponse> getMerchantNumberAndNameById(Long merchantId);

    /**
     * 商户是否入驻
     * @return
     */
    FCResponse<Integer> judgmentMerchantSet();

    /**
     * 获取商户基本信息
     * @return
     */
    FCResponse<MerchantResponse> getMerchantInfo();

    /**
     * 更新商户基本信息
     * @param editMerchantInfo
     * @return
     */
    FCResponse<Void> updateMerchantInfo(EditMerchantInfo editMerchantInfo);
}
