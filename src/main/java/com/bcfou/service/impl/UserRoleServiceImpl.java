package com.bcfou.service.impl;

import com.bcfou.entity.Role;
import com.bcfou.repository.UserRoleRepository;
import com.bcfou.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 21:57
 */
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository repository;
    @Override
    public List<Role> findByUserName(String username) {
        return repository.findByUserName(username);
    }
}
