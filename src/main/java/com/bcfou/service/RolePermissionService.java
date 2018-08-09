package com.bcfou.service;

import com.bcfou.entity.Permission;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 22:41
 */
public interface RolePermissionService {
    List<Permission> findByUserName(String username);
}
