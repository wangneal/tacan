package com.bcfou.service;

import com.bcfou.entity.Role;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 21:57
 */
public interface UserRoleService {
    List<Role> findByUserName(String username);
}
