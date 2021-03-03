package com.codeworld.fc.merchant.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName FeignConfiguration
 * Description 远程调用服务，使用Headers解决权限问题
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
 **/
@Configuration
public class FeignConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");
        requestTemplate.header("token", token);
    }
}
