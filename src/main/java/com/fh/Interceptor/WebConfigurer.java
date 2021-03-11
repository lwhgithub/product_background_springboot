package com.fh.Interceptor;

import com.fh.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
         // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录  放开/UserController/login请求
         //注册登录拦截器 配置需要拦截的路径
         registry.addInterceptor(LoginInterceptor())
                 .addPathPatterns("/**");
//                  配置不需要拦截的路径
//                 .excludePathPatterns("/uploadFile");
     }
     @Bean
     public LoginInterceptor LoginInterceptor() {
         return new LoginInterceptor();
     }


}
