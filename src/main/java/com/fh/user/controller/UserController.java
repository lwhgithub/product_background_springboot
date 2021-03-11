package com.fh.user.controller;


import com.fh.Interceptor.LoginRequired;
import com.fh.Interceptor.SystemVariable;
import com.fh.common.ServerResponse;
import com.fh.user.model.User;
import com.fh.user.server.UserServer;
import com.fh.utils.OssUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-02-21 9:35
 */
@RestController
@RequestMapping("UserController")
public class UserController {

    @Resource
    private UserServer userServer;

    @PostMapping("login")
    @LoginRequired
    public ServerResponse login(User user,HttpServletRequest request, HttpServletResponse response){
        return userServer.login(user,request,response);
    }
    @PostMapping("addregister")
    @LoginRequired
    public ServerResponse addregister(User user, HttpServletRequest request){
        return userServer.addregister(user,request);
    }
    @RequestMapping("loginout")
    @LoginRequired
    public ServerResponse loginout(HttpServletRequest request){
        request.getSession().removeAttribute(SystemVariable.LOGIN_USER);
        return ServerResponse.success();
    }
    @RequestMapping("uploadFile")
    @LoginRequired
    public ServerResponse importPhoto(MultipartFile file){
        return OssUtil.uploadFile(file);
    }
}
