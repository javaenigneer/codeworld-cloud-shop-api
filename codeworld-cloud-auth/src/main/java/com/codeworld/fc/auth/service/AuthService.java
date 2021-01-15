package com.codeworld.fc.auth.service;

import com.codeworld.fc.auth.domain.MerchantInfo;
import com.codeworld.fc.auth.request.*;
import com.codeworld.fc.auth.response.SystemLoginInfoResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.auth.response.MemberInfoResponse;
import com.codeworld.fc.auth.response.UserInfoResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface AuthService {

    /**
     * 会员登录接口
     * @param memberLoginRequest
     * @param request
     * @param response
     * @return
     */
    FCResponse<String> memberLogin(MemberLoginRequest memberLoginRequest, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取会员信息
     * @param tokenRequest
     * @return
     */
    FCResponse<MemberInfoResponse> getMemberInfo(TokenRequest tokenRequest);

    /**
     * 商户登录
     * @param merchantLoginRequest
     * @return
     */
    FCResponse<String> merchantLogin(MerchantLoginRequest merchantLoginRequest, HttpServletRequest request, HttpServletResponse response);

    /**
     * 系统后台登录
     * @param systemLoginRequest
     * @param request
     * @param response
     * @return
     */
    FCResponse<Map<String, Object>> systemLogin(SystemLoginRequest systemLoginRequest, HttpServletRequest request, HttpServletResponse response);

    /**
     * 获取登录用户信息
     * @param tokenRequest
     * @param request
     * @param response
     * @return
     */
    FCResponse<SystemLoginInfoResponse> getSystemLoginInfo(TokenRequest tokenRequest,HttpServletRequest request,
                                                           HttpServletResponse response);

    /**
     * 获取商户信息
     * @param tokenRequest
     * @return
     */
    FCResponse<MerchantInfo> getMerchantInfo(TokenRequest tokenRequest);
}
