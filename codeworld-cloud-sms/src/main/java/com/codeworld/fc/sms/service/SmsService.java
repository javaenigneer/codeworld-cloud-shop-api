package com.codeworld.fc.sms.service;

import com.codeworld.fc.common.response.FCResponse;

public interface SmsService {
    /**
     * 发送短信
     * @param phone
     * @return
     */
    FCResponse<String> sendSms(String phone);
}
