package com.codeworld.fc.config;

import com.codeworld.fc.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName InterceptorConfig
 * Description TODO
 * Author Lenovo
 * Date 2020/12/24
 * Version 1.0
**/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor())
                .addPathPatterns("/**");
    }
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }
}
