package com.codeworld.fc.sms.controller;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.sms.service.SmsService;
import com.sun.org.apache.bcel.internal.generic.FCMPG;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName SmsController
 * Description 短信接口管理
 * Author Lenovo
 * Date 2020/12/18
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-sms")
@Api(tags = "短信接口管理")
public class SmsController {

    @Autowired(required = false)
    private SmsService smsService;

    @PostMapping("send-sms")
    @ApiOperation("发送短信")
    public FCResponse<String> sendSms(@RequestParam("phone") String phone){
        return this.smsService.sendSms(phone);
    }
}
