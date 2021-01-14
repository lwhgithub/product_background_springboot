package com.fh.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author czx
 * @create 2020-10-18 16:13
 */
public class WebContextRequestUtil {

    private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<>();

    public static void setRequest(HttpServletRequest request){
        threadLocal.set(request);
    }

    public static HttpServletRequest getRequest(){
        return threadLocal.get();
    }

    public static void remove(){
        threadLocal.remove();
    }

}
