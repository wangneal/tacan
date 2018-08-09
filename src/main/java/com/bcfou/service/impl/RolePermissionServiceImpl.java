package com.bcfou.service.impl;

import com.bcfou.entity.Permission;
import com.bcfou.repository.RolePermissionRepository;
import com.bcfou.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 22:42
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionRepository repository;
    @Override
    public List<Permission> findByUserName(String username) {
        return repository.findByUserName(username);
    }
}
