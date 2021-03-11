package com.fh.Interceptor;

import java.lang.annotation.*;

/**
 * @author winter
 * @create 2020-10-16 8:20
 */
@Target(ElementType.METHOD) //ElementType.TYPE注解可以在类上使用
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginRequired {
//    自定义注解 用来判断进行登录时是否需要拦截，加在controller层方法上面
}
