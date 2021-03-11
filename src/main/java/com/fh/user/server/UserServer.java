package com.fh.user.server;

import com.fh.common.ServerResponse;
import com.fh.user.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-02-21 9:37
 */
public interface UserServer {
    ServerResponse addregister(User user, HttpServletRequest request);

    ServerResponse login(User user, HttpServletRequest request, HttpServletResponse response);
}
