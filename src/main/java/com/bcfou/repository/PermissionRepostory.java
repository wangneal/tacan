package com.bcfou.repository;

import com.bcfou.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 20:20
 */
public interface PermissionRepostory extends JpaRepository<Permission, Integer> {
}
