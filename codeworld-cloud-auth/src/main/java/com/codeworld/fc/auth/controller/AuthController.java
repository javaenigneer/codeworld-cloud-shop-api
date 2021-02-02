package com.codeworld.fc.auth.controller;

import com.codeworld.fc.auth.domain.MerchantInfo;
import com.codeworld.fc.auth.request.*;
import com.codeworld.fc.auth.response.SystemLoginInfoResponse;
import com.codeworld.fc.auth.service.AuthService;
import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.auth.response.MemberInfoResponse;
import com.codeworld.fc.auth.response.UserInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * ClassName AuthController
 * Description 登录授权接口管理
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
 **/
@RestController
@RequestMapping("codeworld-auth")
@Api(tags = "登录授权接口管理")
public class AuthController {

    @Autowired(required = false)
    private AuthService authService;

    @PostMapping("/app/member-login")
    @ApiOperation("会员登录接口app端")
    @PassToken
    public FCResponse<String> memberLogin(@RequestBody @Valid MemberLoginRequest memberLoginRequest,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
        return this.authService.memberLogin(memberLoginRequest, request, response);
    }

    @PostMapping("/app/get-member-info")
    @ApiOperation("获取会员信息App端")
    public FCResponse<MemberInfoResponse> getMemberInfo(@RequestBody @Valid TokenRequest tokenRequest) {
        return this.authService.getMemberInfo(tokenRequest);
    }

    @PostMapping("/app/merchant-login")
    @ApiOperation("商户登录app端")
    @PassToken
    public FCResponse<String> merchantLogin(@RequestBody @Valid MerchantLoginRequest merchantLoginRequest,
                                            HttpServletRequest request,
                                            HttpServletResponse response) {
        return this.authService.merchantLogin(merchantLoginRequest, request, response);
    }

    @PostMapping("/app/get-merchant-info")
    @ApiOperation("获取商户信息app端")
    @PassToken
    public FCResponse<MerchantInfo> getMerchantInfo(@RequestBody @Valid TokenRequest tokenRequest){
        return this.authService.getMerchantInfo(tokenRequest);
    }

    @PostMapping("/web/system/system-login")
    @ApiOperation("系统后台登录web端")
    @PassToken
    public FCResponse<Map<String, Object>> systemLogin(@RequestBody @Valid SystemLoginRequest systemLoginRequest,
                                                       HttpServletRequest request,
                                                       HttpServletResponse response){
        return this.authService.systemLogin(systemLoginRequest,request,response);
    }

    // 获取登录用户信息
    @PostMapping("/web/system/get-system-login-info")
    @ApiOperation("获取登录用户信息web端")
    public FCResponse<SystemLoginInfoResponse> getSystemLoginInfo(@RequestBody @Valid TokenRequest tokenRequest,
                                                                  HttpServletRequest request,
                                                                  HttpServletResponse response){
        return this.authService.getSystemLoginInfo(tokenRequest,request,response);
    }

    @PostMapping("/web/merchant/system-login")
    @ApiOperation("商户系统登录web端")
    @PassToken
    public FCResponse<Map<String,Object>> merchantSystemLogin(@RequestBody @Valid SystemLoginRequest systemLoginRequest,
                                                              HttpServletRequest request,
                                                              HttpServletResponse response){
        return this.authService.merchantSystemLogin(systemLoginRequest,request,response);
    }


    @PostMapping("login-out")
    @ApiOperation("退出登录")
    @PassToken
    public FCResponse<Void> loginOut(){
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_LOGIN_OUT_SUCCESS.getMsg());
    }

}
