package com.codeworld.fc.merchant.mapper;

import com.codeworld.fc.merchant.entity.Merchant;
import com.codeworld.fc.merchant.entity.MerchantWxInfo;
import com.codeworld.fc.merchant.request.MerchantSearchRequest;
import com.codeworld.fc.merchant.response.MerchantResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MerchantMapper {


    /**
     * 商户注册
     * @param merchant
     */
    void registerMerchant(Merchant merchant);

    /**
     * 根据手机号
     * @param phone
     * @return
     */
    Integer checkMerchantByPhone(String phone);

    /**
     * 根据手机号获取商户信息
     * @param phone
     * @return
     */
    MerchantResponse getMerchantByPhone(String phone);

    /**
     * 分页查询商户
     * @param merchantSearchRequest
     * @return
     */
    List<MerchantResponse> getPageMerchant(MerchantSearchRequest merchantSearchRequest);

    /**
     * 根据商户号判断是否存在
     * @param merchantNumber
     * @return
     */
    Integer checkMerchantByMerchantNumber(String merchantNumber);

    /**
     * 根据商户号获取商户信息
     * @param merchantNumber
     * @return
     */
    MerchantResponse getMerchantByMerchantNumber(String merchantNumber);

    /**
     * 根据商户Id获取商户号
     * @param id
     * @return
     */
    String getMerchantByMerchantId(Long id);

    /**
     * 根据商户Id获取商户信息
     * @param merchantId
     * @return
     */
    MerchantResponse getMerchantNumberAndNameById(Long merchantId);

    /**
     * 获取商户注册7天后，未进行入驻
     * @return
     */
    List<MerchantResponse> getAllNoMerchantSet();

    /**
     * 删除未入驻商户数据
     * @param merchantNumbers
     */
    void deleteNoMerchantSet(List<String> merchantNumbers);

    /**
     * 判断商户是否入驻
     * @param id
     * @return
     */
    Integer judgmentMerchantSet(Long id);

    /**
     * 获取商户基本信息
     * @param id
     * @return
     */
    MerchantResponse getMerchantInfoById(Long id);

    /**
     * 更新商户基本信息
     * @param merchant
     */
    void updateMerchantInfo(Merchant merchant);

    /**
     * 商户转移
     * @param merchant
     */
    void transferMerchantWeb(Merchant merchant);

    /**
     * 修改密码
     * @param merchant
     */
    void resetPassword(Merchant merchant);

    /**
     * 根据openid获取商户信息
     * @param openId
     * @return
     */
    MerchantWxInfo getMerchantByOpenId(String openId);
}
