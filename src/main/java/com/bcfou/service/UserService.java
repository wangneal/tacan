package com.bcfou.service;

import com.bcfou.entity.User;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 10:51
 */
public interface UserService {
    User findByUserName(String username);
    User save(User user);
}
