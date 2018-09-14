package com.myuserid.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器，
 * Created by Administrator on 2018/8/1.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public HandlerInterceptor getSignInterceptor(){
        return new SignInterceptor();
    }

    @Bean
    public HandlerInterceptor getAuthenticationInterceptor(){
        return new AuthenticationInterceptor();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getAuthenticationInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getSignInterceptor()).addPathPatterns("/**");
    }
}
