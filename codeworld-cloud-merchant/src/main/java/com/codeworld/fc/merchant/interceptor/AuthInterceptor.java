package com.codeworld.fc.merchant.interceptor;


import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.utils.JwtUtils;
import com.codeworld.fc.merchant.domain.MerchantInfo;
import com.codeworld.fc.merchant.properties.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * ClassName AuthInterceptor
 * Description 用户认证登录过滤器
 * Author Lenovo
 * Date 2020/12/24
 * Version 1.0
**/
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    private JwtProperties jwtProperties;

    // 定义一个线程域，存放登录用户
    private static final ThreadLocal<LoginInfoData> tl = new ThreadLocal<>();
    /**
     * 认证
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取请求头里的token
        String token = request.getHeader("token");
        if(!(handler instanceof HandlerMethod)){
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }
        }else {
            // 执行认证
            if (ObjectUtils.isEmpty(token)){
                throw new FCException("登录失效，请重新登录");
            }
            try {
                // 根据token获取信息
                LoginInfoData loginInfoData = JwtUtils.getInfoFromToken(token, jwtProperties.getPublicKey());
                if (ObjectUtils.isEmpty(loginInfoData)){
                    throw new FCException("登录失效，请重新登录");
                }
                // 放入线程域
                tl.set(loginInfoData);
                // 验证通过
                return HandlerInterceptor.super.preHandle(request, response, handler);
            }catch (Exception e){
                e.printStackTrace();
                throw new FCException("登录失效，请重新登录");
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    /**
     * 获取当前登录商户
     * @return
     */
    public static LoginInfoData getLoginMerchant() {
        return tl.get();
    }

}
