package com.bcfou.service.impl;

import com.bcfou.entity.User;
import com.bcfou.repository.UserRepository;
import com.bcfou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 10:52
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User findByUserName(String username) {
        return repository.findByUserName(username);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
