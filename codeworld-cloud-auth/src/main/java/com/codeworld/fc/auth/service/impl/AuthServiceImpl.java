package com.codeworld.fc.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.auth.client.*;
import com.codeworld.fc.auth.domain.*;
import com.codeworld.fc.auth.properties.JwtProperties;
import com.codeworld.fc.auth.request.*;
import com.codeworld.fc.auth.response.SystemLoginInfoResponse;
import com.codeworld.fc.auth.service.AuthService;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.enums.StatusEnum;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.*;
import com.codeworld.fc.auth.response.MemberInfoResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * ClassName AuthServiceImpl
 * Description
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired(required = false)
    private JwtProperties jwtProperties;
    @Autowired(required = false)
    private UserClient userClient;
    @Autowired(required = false)
    private RoleClient roleClient;
    @Autowired(required = false)
    private MenuClient menuClient;
    @Autowired(required = false)
    private MemberClient memberClient;
    @Autowired(required = false)
    private MerchantClient merchantClient;

    /**
     * 会员登录接口
     *
     * @param memberLoginRequest
     * @param request
     * @param response
     * @return
     */
    @Override
    public FCResponse<String> memberLogin(MemberLoginRequest memberLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        // 根据手机号查询用户是否注册
        FCResponse<Integer> fcResponse = this.memberClient.checkMemberByPhone(memberLoginRequest.getPhone());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        if (fcResponse.getData() == 0) {
            // 未注册
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.member.MEMBER_NOT_REGISTER.getMsg(), null);
        }
        // 根据手机号获取会员信息
        FCResponse<MemberResponse> memberFcResponse = this.memberClient.getMemberByPhone(memberLoginRequest.getPhone());
        if (!memberFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        // 比对密码
        MemberResponse memberResponse = memberFcResponse.getData();
        if (!StringUtils.equals(memberResponse.getPassword(), memberLoginRequest.getPassword())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.member.MEMBER_MESSAGE_ERROR.getMsg(), null);
        }
        // 执行登录
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberId(memberResponse.getId());
        memberInfo.setMemberPhone(memberResponse.getPhone());
        LoginInfoData loginInfoData = new LoginInfoData();
        loginInfoData.setId(memberInfo.getMemberId());
        loginInfoData.setPhone(memberInfo.getMemberPhone());
        // 设置为会员标识
        loginInfoData.setResources("member");
        try {
            String token = JwtUtils.generateToken(loginInfoData, this.jwtProperties.getPrivateKey(), this.jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getCookieMaxAge() * 60);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.member.MEMBER_LOGIN_SUCCESS.getMsg(), token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取会员信息
     *
     * @param tokenRequest
     * @return
     */
    @Override
    public FCResponse<MemberInfoResponse> getMemberInfo(TokenRequest tokenRequest) {
        try {

            LoginInfoData loginInfoData = JwtUtils.getInfoFromToken(tokenRequest.getToken(), jwtProperties.getPublicKey());
            if (ObjectUtils.isEmpty(loginInfoData)) {
                return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.member.MEMBER_DATA_EXPIRE.getMsg(), null);
            }
            // 根据会员Id获取会员信息
            FCResponse<MemberReceiverAddressInfo> memberResponse = this.memberClient.getMemberReceiverAddressByMemberId(loginInfoData.getId());
            if (!memberResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.member.MEMBER_DATA_EXPIRE.getMsg(), null);
            }
            MemberReceiverAddressInfo memberReceiverAddressInfo = memberResponse.getData();
            MemberInfoResponse memberInfoResponse = new MemberInfoResponse();
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemberId(loginInfoData.getId());
            memberInfo.setMemberPhone(loginInfoData.getPhone());
            memberInfo.setMemberName(memberReceiverAddressInfo.getName());
            memberInfoResponse.setMemberInfo(memberInfo);
            memberInfoResponse.setReceiverAddresses(memberReceiverAddressInfo.getAddresses());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.member.MEMBER_DATA_SUCCESS.getMsg(), memberInfoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 商户登录
     *
     * @param merchantLoginRequest
     * @return
     */
    @Override
    public FCResponse<String> merchantLogin(MerchantLoginRequest merchantLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        // 根据手机号查询是否被注册
        FCResponse<Integer> fcResponse = this.merchantClient.checkMerchantByPhone(merchantLoginRequest.getPhone());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        if (fcResponse.getData() == 0) {
            // 未注册
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.member.MEMBER_NOT_REGISTER.getMsg(), null);
        }
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantByPhone(merchantLoginRequest.getPhone());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        // 校验密码
        // 比对密码
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        if (!StringUtils.equals(merchantResponse.getPassword(), merchantLoginRequest.getPassword())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.merchant.MERCHANT_MESSAGE_ERROR.getMsg(), null);
        }
        // 执行登录
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(merchantResponse.getId());
        merchantInfo.setPhone(merchantResponse.getPhone());
        LoginInfoData loginInfoData = new LoginInfoData();
        loginInfoData.setId(merchantInfo.getId());
        loginInfoData.setPhone(merchantResponse.getPhone());
        // 设置为商户标识
        loginInfoData.setResources("merchant");
        try {
            String token = JwtUtils.generateToken(loginInfoData, this.jwtProperties.getPrivateKey(), this.jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getCookieMaxAge() * 60);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_LOGIN_SUCCESS.getMsg(), token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 系统后台登录
     *
     * @param systemLoginRequest
     * @param request
     * @param response
     * @return
     */
    @Override
    public FCResponse<Map<String, Object>> systemLogin(SystemLoginRequest systemLoginRequest, HttpServletRequest request, HttpServletResponse response) {

        // 根据用户名查询用户
        FCResponse<User> userFCResponse = this.userClient.getUserByName(systemLoginRequest.getUsername());
        if (!userFCResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), userFCResponse.getMsg(), null);
        }
        User user = userFCResponse.getData();
        if (user.getUserStatus().equals(StatusEnum.USER_DISABLE)) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.user.USER_DISABLE.getMsg(), null);
        }
        // 校验密码
        if (!StringUtils.equals("123456", systemLoginRequest.getPassword())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.user.USER_MESSAGE_ERROR.getMsg(), null);
        }
        // 执行登录
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setPhone(user.getUserPhone());
        LoginInfoData loginInfoData = new LoginInfoData();
        loginInfoData.setId(userInfo.getUserId());
        loginInfoData.setPhone(userInfo.getPhone());
        // 设置为系统标识
        loginInfoData.setResources("system");
        try {
            String token = JwtUtils.generateToken(loginInfoData, this.jwtProperties.getPrivateKey(), this.jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getCookieMaxAge() * 60);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_LOGIN_SUCCESS.getMsg(), map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取登录用户信息
     *
     * @param tokenRequest
     * @param request
     * @param response
     * @return
     */
    @Override
    public FCResponse<SystemLoginInfoResponse> getSystemLoginInfo(TokenRequest tokenRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginInfoData loginInfoData = JwtUtils.getInfoFromToken(tokenRequest.getToken(), this.jwtProperties.getPublicKey());
            if (ObjectUtils.isEmpty(loginInfoData)) {
                throw new FCException("登录过期");
            }
            SystemLoginInfoResponse systemLoginInfoResponse = new SystemLoginInfoResponse();
            // 判断是哪一种登录
            String resources = loginInfoData.getResources();
            // 系统管理员登录
            if ("system".equals(resources)) {
                // 查询角色管理员信息
                FCResponse<User> fcResponse = this.userClient.getUserById(loginInfoData.getId());
                if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                    return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg());
                }
                User user = fcResponse.getData();
                systemLoginInfoResponse.setAvatar(user.getAvatar());
            }
            // 商户登录
            else if ("merchant".equals(resources)) {
                // 查询商户信息
                FCResponse<MerchantResponse> fcResponse = this.merchantClient.getMerchantInfoById(loginInfoData.getId());
                if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())){
                    return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg());
                }
                MerchantResponse merchantResponse = fcResponse.getData();
                systemLoginInfoResponse.setAvatar(merchantResponse.getAvatar());
            }
            Set<String> roles = new HashSet<>();
            Set<MenuVO> menuVOS = new HashSet<>();
            Set<ButtonVO> buttonVOS = new HashSet<>();
            // 根据用户id查询角色信息
            FCResponse<Role> roleFcResponse = this.roleClient.getRoleByUserId(loginInfoData.getId());
            if (roleFcResponse.getCode().equals(HttpFcStatus.PARAMSERROR.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), roleFcResponse.getMsg());
            }
            roles.add(roleFcResponse.getData().getRoleCode());
            // 根据角色id查询角色权限
            FCResponse<List<Menu>> menuFcResponse = this.menuClient.getMenuByRoleId(roleFcResponse.getData().getRoleId());
            if (menuFcResponse.getCode().equals(HttpFcStatus.PARAMSERROR.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), menuFcResponse.getMsg());
            }
            if (ObjectUtils.isEmpty(menuFcResponse.getData())) {
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), menuFcResponse.getMsg());
            }
            List<Menu> menus = menuFcResponse.getData();
            // 菜单不为空
            if (!CollectionUtils.isEmpty(menus)) {
                menus.stream().filter(Objects::nonNull).forEach(menu -> {
                    // 按钮权限
                    if (StringUtils.equalsIgnoreCase("button", menu.getType())) {
                        // 添加到按钮权限
                        ButtonVO buttonVO = new ButtonVO();
                        BeanUtil.copyProperties(menu, buttonVO);
                        buttonVOS.add(buttonVO);
                    }
                    // 菜单权限
                    if (StringUtils.equalsIgnoreCase("menu", menu.getType())) {
                        // 添加到菜单权限
                        MenuVO menuVO = new MenuVO();
                        BeanUtil.copyProperties(menu, menuVO);
                        menuVOS.add(menuVO);
                    }
                });
            }
            systemLoginInfoResponse.getRoles().addAll(roles);
            systemLoginInfoResponse.getButtons().addAll(buttonVOS);
            systemLoginInfoResponse.getMenus().addAll(TreeBuilder.buildTree(menuVOS));
            systemLoginInfoResponse.setLoginIp(IPUtil.getIpAddr(request));
            systemLoginInfoResponse.setLoginLocation(AddressUtil.getCityInfo(IPUtil.getIpAddr(request)));
            systemLoginInfoResponse.setLoginTime(new Date());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.user.USER_AUTH_SUCCESS.getMsg(), systemLoginInfoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取商户信息
     *
     * @param tokenRequest
     * @return
     */
    @Override
    public FCResponse<MerchantInfo> getMerchantInfo(TokenRequest tokenRequest) {
        try {
            LoginInfoData loginInfoData = JwtUtils.getInfoFromToken(tokenRequest.getToken(), jwtProperties.getPublicKey());
            if (ObjectUtils.isEmpty(loginInfoData) || !StringUtils.equals("merchant", loginInfoData.getResources())) {
                return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.member.MEMBER_DATA_EXPIRE.getMsg(), null);
            }
            FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantInfoById(loginInfoData.getId());
            if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
                return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), merchantFcResponse.getMsg(), null);
            }
            MerchantResponse merchantResponse = merchantFcResponse.getData();
            MerchantInfo merchantInfo = new MerchantInfo();
            merchantInfo.setId(merchantResponse.getId());
            merchantInfo.setPhone(merchantResponse.getPhone());
            merchantInfo.setMerchantName(merchantResponse.getMerchantName());
            merchantInfo.setNumber(merchantResponse.getNumber());
            merchantInfo.setNickName(merchantResponse.getNickName());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_DATA_SUCCESS.getMsg(), merchantInfo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }

    }

    /**
     * 商户登录商户系统
     *
     * @param systemLoginRequest
     * @param request
     * @param response
     * @return
     */
    @Override
    public FCResponse<Map<String, Object>> merchantSystemLogin(SystemLoginRequest systemLoginRequest, HttpServletRequest request, HttpServletResponse response) {
        // 进行商户登录
        FCResponse<Integer> fcResponse = this.merchantClient.checkMerchantByMerchantNumber(systemLoginRequest.getUsername());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        // 判断商户是否注册
        if (fcResponse.getData() == 0) {
            // 未注册
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.merchant.MERCHANT_NO_REGISTER.getMsg(), null);
        }
        // 根据商户号获取商户信息
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantByMerchantNumber(systemLoginRequest.getUsername());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), fcResponse.getMsg(), null);
        }
        // 校验密码
        // 比对密码
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        if (!StringUtils.equals(merchantResponse.getPassword(), systemLoginRequest.getPassword())) {
            return FCResponse.dataResponse(HttpFcStatus.AUTHFAILCODE.getCode(), HttpMsg.merchant.MERCHANT_MESSAGE_ERROR.getMsg(), null);
        }
        // 执行登录
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(merchantResponse.getId());
        merchantInfo.setPhone(merchantResponse.getPhone());
        LoginInfoData loginInfoData = new LoginInfoData();
        loginInfoData.setId(merchantInfo.getId());
        loginInfoData.setPhone(merchantResponse.getPhone());
        // 设置为商户标识
        loginInfoData.setResources("merchant");
        try {
            String token = JwtUtils.generateToken(loginInfoData, this.jwtProperties.getPrivateKey(), this.jwtProperties.getExpire());
            CookieUtils.setCookie(request, response, jwtProperties.getCookieName(), token, jwtProperties.getCookieMaxAge() * 60);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.merchant.MERCHANT_LOGIN_SUCCESS.getMsg(), map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
