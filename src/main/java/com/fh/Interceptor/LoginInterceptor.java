package com.fh.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.ServerResponse;

import com.fh.user.model.User;
import com.fh.utils.JWTUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * @author winter
 * @create 2020-10-15 21:34
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一次请求的session但是不一样的，解决方法。
        // 前台vue cookies无法传到后台main.js:; axios.defaults.withCredentials=true
        //获取跨域路径
        String origin = request.getHeader("Origin");
        //解决跨域 本质  设置response的相关信息  //设置允许跨域的资源
        response.addHeader("Access-Control-Allow-Origin", origin);
        //设置运行cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //注解登录拦截器 判断是否需要拦截请求  controller层加@LoginRequired不需要拦截
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired annotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (annotation != null){
            return true;
        }
        String token = request.getParameter("token");
        if(token == null){
            ServerResponse serverResponse = ServerResponse.no_login();
            response.getWriter().write(JSONObject.toJSONString(serverResponse));
            return false;
        }
        // 验证token  1 得到token
        //解密
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(token);
        String tokenStr=new String(decode);
        //得到name 和token
        String[] liuwenhao = tokenStr.split("liuwenhao");
        if(liuwenhao.length!=2){
            ServerResponse serverResponse = ServerResponse.error_login();
            response.getWriter().write(JSONObject.toJSONString(serverResponse));
            return false;
        }
        User unsign = JWTUtil.unsign(liuwenhao[1], User.class);
        if(unsign==null){
            ServerResponse serverResponse = ServerResponse.error_login();
            response.getWriter().write(JSONObject.toJSONString(serverResponse));
            return false;
        }
        return true;

    }
}
