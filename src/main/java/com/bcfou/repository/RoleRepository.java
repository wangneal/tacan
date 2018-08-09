package com.bcfou.repository;

import com.bcfou.entity.Permission;
import com.bcfou.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 20:19
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
