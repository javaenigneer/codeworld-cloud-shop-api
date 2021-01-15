package com.codeworld.fc.sms.service.impl;

import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.common.utils.StringUtil;
import com.codeworld.fc.sms.service.SmsService;
import com.netflix.ribbon.proxy.annotation.Http;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * ClassName SmsServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/18
 * Version 1.0
**/
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    private final String PHONE_CODE = "PHONE_CODE:";

    /**
     * 发送短信
     *
     * @param phone
     * @return
     */
    public FCResponse<String> sendSms(String phone) {
        if (!StringUtil.checkPhone(phone)){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.sms.SMS_PHONE_ERROR.getMsg());
        }
        // 默认验证码
        String code = "888888";
        // 将验证码保存到Redis中,两分钟失效
        this.stringRedisTemplate.opsForValue().set(PHONE_CODE + phone, code, 60 * 2, TimeUnit.SECONDS);
        log.info("短信发送成功，手机号为：{}",phone);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.sms.SMS_PHONE_SUCCESS.getMsg(),code);
    }
}
