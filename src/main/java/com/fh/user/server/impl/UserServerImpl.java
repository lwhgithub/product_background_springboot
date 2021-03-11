package com.fh.user.server.impl;

import com.fh.common.ServerResponse;
import com.fh.Interceptor.SystemVariable;
import com.fh.user.mapper.UserMapper;
import com.fh.user.model.User;
import com.fh.user.server.UserServer;
import com.fh.utils.JWTUtil;
import com.fh.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-02-21 9:38
 */
@Service
public class UserServerImpl implements UserServer {
    @Resource
    private UserMapper userMapper;

    @Override
    public ServerResponse login(User user, HttpServletRequest request, HttpServletResponse response) {

        if(user==null || user.getUserName().equals("") || user.getUserPassword().equals("")){
            return ServerResponse.error("用户名或者密码为空");
        }
        User userDB = userMapper.queryUserName(user.getUserName());
        if (userDB==null){
            return ServerResponse.error("你登录的用户名不存在,请查看你的用户名是否正确");
        }
        if (!MD5Util.verify(user.getUserPassword(),userDB.getUserPassword())){
            return ServerResponse.error("密码错误");
        }
        String jwttoken = JWTUtil.sign(userDB);

        //将token信息进行base64加密  得到加密类
        Base64.Encoder encoder = Base64.getEncoder();
        //设置加密信息 字节数组
        byte[] userinfo=(user.getUserName()+"liuwenhao"+jwttoken).getBytes();
        //加密密文
        byte[] encode = encoder.encode(userinfo);
        //将字节数组 转为字符串
        String token=new String(encode);

        return ServerResponse.success(token);
    }

    @Override
    public ServerResponse addregister(User user, HttpServletRequest request) {
        if(user==null || user.getUserName().equals("") || user.getUserPassword().equals("")){
            return ServerResponse.error("用户名或者密码为空");
        }
        if(user.getUserPhone().equals("")){
            return ServerResponse.error("手机号不能为空");
        }
        if(!user.getUserPassword().equals(user.getCheckpass())){
            return ServerResponse.error("两次输入的密码不一致");
        }
        User userDB = userMapper.queryUserName(user.getUserName());
        if (userDB!=null){
            return ServerResponse.error("当前用户名已经存在");
        }
        user.setUserCreateDate(new Date());
        String MD5password = MD5Util.generate(user.getUserPassword());
        user.setUserPassword(MD5password);
        userMapper.addregister(user);
        return ServerResponse.success();
    }


}
