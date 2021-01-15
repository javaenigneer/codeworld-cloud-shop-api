package com.codeworld.fc.merchant.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.StringUtil;
import com.codeworld.fc.merchant.client.RoleClient;
import com.codeworld.fc.merchant.domain.MerchantInfo;
import com.codeworld.fc.merchant.domain.UserRole;
import com.codeworld.fc.merchant.entity.MerChantDetail;
import com.codeworld.fc.merchant.entity.Merchant;
import com.codeworld.fc.merchant.interceptor.AuthInterceptor;
import com.codeworld.fc.merchant.mapper.MerChantDetailMapper;
import com.codeworld.fc.merchant.mapper.MerchantMapper;
import com.codeworld.fc.merchant.request.ExamineMerchantRequest;
import com.codeworld.fc.merchant.request.MerchantAddRequest;
import com.codeworld.fc.merchant.request.MerchantRegisterRequest;
import com.codeworld.fc.merchant.request.MerchantSearchRequest;
import com.codeworld.fc.merchant.response.MerchantResponse;
import com.codeworld.fc.merchant.service.MerchantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName MerchantServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@Service
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    private final String PHONE_CODE = "PHONE_CODE:";
    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    private MerchantMapper merchantMapper;

    @Autowired(required = false)
    private MerChantDetailMapper merChantDetailMapper;

    @Autowired(required = false)
    private RoleClient roleClient;

    /**
     * 商家入驻
     *
     * @param merchantAddRequest
     * @return
     */
    public FCResponse<Void> merchantSettled(MerchantAddRequest merchantAddRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginMerchant();
        // 根据商户Id获取商户号
        String number = this.merchantMapper.getMerchantByMerchantId(loginInfoData.getId());
        // 查询商户是否入驻
        Integer status = this.merChantDetailMapper.getMerchantStatusByMerchantNumber(number);
        if (status != 3){
            return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(),HttpMsg.merchant.MERCHANT_EXIST.getMsg());
        }
        MerChantDetail merChantDetail = new MerChantDetail();
        BeanUtil.copyProperties(merchantAddRequest,merChantDetail);
        merChantDetail.setMerchantNumber(number);
        // 设置为未审核
        merChantDetail.setStatus(2);
        merChantDetail.setCreateTime(new Date());
        this.merChantDetailMapper.merchantSettled(merChantDetail);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_SETTLED_ADD_SUCCESS.getMsg());
    }

    /**
     * 商户注册
     *
     * @param merchantRegisterRequest
     * @return
     */
    public FCResponse<String> registerMerchant(MerchantRegisterRequest merchantRegisterRequest) {
        // 先从数据库中获取改手机号是否被注册
        Integer count = this.merchantMapper.checkMerchantByPhone(merchantRegisterRequest.getPhone());
        if (count != 0){
            // 清空redis中手机号验证码
            this.stringRedisTemplate.delete(PHONE_CODE + merchantRegisterRequest.getPhone());
            return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(),HttpMsg.merchant.MERCHANT_PHONE_REGISTER.getMsg());
        }
        // 从Redis中获取验证码
        // 判断验证码是否存在
        if (!this.stringRedisTemplate.hasKey(PHONE_CODE + merchantRegisterRequest.getPhone())) {
            log.info("验证码已过期：" + merchantRegisterRequest.getPhone());
            return FCResponse.dataResponse(HttpFcStatus.VALIDATEFAILCODE.getCode(), HttpMsg.sms.SMS_CODE_EXPIRE.getMsg());
        }
        String code = this.stringRedisTemplate.opsForValue().get(PHONE_CODE + merchantRegisterRequest.getPhone());
        // 校验验证码
        if (!StringUtils.equals(merchantRegisterRequest.getCode(), code)) {
            log.info("验证码错误");
            return FCResponse.dataResponse(HttpFcStatus.VALIDATEFAILCODE.getCode(), HttpMsg.sms.SMS_CODE_ERROR.getMsg());
        }

        // 验证通过实现注册
        Merchant merchant = new Merchant();
        merchant.setId(IDGeneratorUtil.getMerchantId());
        merchant.setNumber(String.valueOf(IDGeneratorUtil.getMerchantNumber()));
        merchant.setNickName(merchantRegisterRequest.getNickName());
        merchant.setPhone(merchantRegisterRequest.getPhone());
        merchant.setPassword(merchantRegisterRequest.getPassword());
        merchant.setCreateTime(new Date());
        this.merchantMapper.registerMerchant(merchant);
        // 设置商户为未入住状态
        MerChantDetail merChantDetail = new MerChantDetail();
        merChantDetail.setMerchantNumber(merchant.getNumber());
        merChantDetail.setStatus(3);
        this.merChantDetailMapper.addMerchantDetail(merChantDetail);
        // 添加到商户角色
        // 默认写死 商户角色 ---853858
        UserRole userRole = new UserRole();
        userRole.setUserRoleId(IDGeneratorUtil.getNextId());
        userRole.setRoleId(853858L);
        userRole.setUserId(merchant.getId());
        userRole.setCreateTime(new Date());
        userRole.setUpdateTime(userRole.getCreateTime());
        this.roleClient.addUserRole(userRole);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_ADD_SUCCESS.getMsg(),merchant.getNumber());
    }

    /**
     * 根据手机号判断是否被注册
     *
     * @param phone
     * @return
     */
    public FCResponse<Integer> checkMerchantByPhone(String phone) {
        // 手机号错误
        if (!StringUtil.checkPhone(phone)) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.sms.SMS_PHONE_ERROR.getMsg(), 0);
        }
        Integer count = this.merchantMapper.checkMerchantByPhone(phone);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(), count);
    }

    /**
     * 根据手机号获取商户信息
     *
     * @param phone
     * @return
     */
    public FCResponse<MerchantResponse> getMerchantByPhone(String phone) {
        // 手机号错误
        if (!StringUtil.checkPhone(phone)) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.sms.SMS_PHONE_ERROR.getMsg(), null);
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantByPhone(phone);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(), merchantResponse);
    }

    /**
     * 分页查询商户
     * @param merchantSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<MerchantResponse>>> getPageMerchant(MerchantSearchRequest merchantSearchRequest) {
        PageHelper.startPage(merchantSearchRequest.getPage(),merchantSearchRequest.getLimit());
        List<MerchantResponse> merchantResponses = this.merchantMapper.getPageMerchant(merchantSearchRequest);
        if (CollectionUtils.isEmpty(merchantResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg(),DataResponse.dataResponse(merchantResponses,0L));
        }
        PageInfo<MerchantResponse> pageInfo = new PageInfo<>(merchantResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(),DataResponse.dataResponse(pageInfo.getList(),pageInfo.getTotal()));
    }

    /**
     * 根据商户号判断该商户是否存在
     *
     * @param merchantNumber
     * @return
     */
    @Override
    public FCResponse<Integer> checkMerchantByMerchantNumber(String merchantNumber) {
       if (ObjectUtils.isEmpty(merchantNumber)){
           return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.merchant.MERCHANT_ID_ERROR.getMsg());
       }
       Integer count = this.merchantMapper.checkMerchantByMerchantNumber(merchantNumber);
       return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(),count);
    }

    /**
     * 根据商户号获取商户
     *
     * @param merchantNumber
     * @return
     */
    @Override
    public FCResponse<MerchantResponse> getMerchantByMerchantNumber(String merchantNumber) {
        if (ObjectUtils.isEmpty(merchantNumber)){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.merchant.MERCHANT_ID_ERROR.getMsg());
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantByMerchantNumber(merchantNumber);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(), merchantResponse);
    }

    /**
     * 审核商户
     *
     * @param examineMerchantRequest
     * @return
     */
    @Override
    public FCResponse<Void> examineMerchant(ExamineMerchantRequest examineMerchantRequest) {
        MerChantDetail merChantDetail = new MerChantDetail();
        merChantDetail.setMerchantNumber(examineMerchantRequest.getNumber());
        merChantDetail.setStatus(examineMerchantRequest.getStatus());
        // 审核
        this.merChantDetailMapper.examineMerchant(merChantDetail);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_EXAMINE_SUCCESS.getMsg());
    }

    /**
     * 根据商户id获取商户信息
     *
     * @param merchantId
     * @return
     */
    @Override
    public FCResponse<MerchantResponse> getMerchantNumberAndNameById(Long merchantId) {

        if (ObjectUtils.isEmpty(merchantId) || merchantId <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.merchant.MERCHANT_ID_ERROR.getMsg());
        }
        MerchantResponse merchantResponse = this.merchantMapper.getMerchantNumberAndNameById(merchantId);
        if (ObjectUtils.isEmpty(merchantResponse)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.merchant.MERCHANT_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(),merchantResponse);
    }
}
