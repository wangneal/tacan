package com.bcfou.repository;

import com.bcfou.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 19:23
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
