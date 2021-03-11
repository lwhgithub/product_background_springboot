package com.fh.user.mapper;

import com.fh.user.model.User;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-02-21 9:35
 */
public interface UserMapper {
    void addregister(User user);

    User queryUserName(String userName);
}
