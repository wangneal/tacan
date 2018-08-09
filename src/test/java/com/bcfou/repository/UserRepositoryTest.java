package com.bcfou.repository;

import com.bcfou.entity.Permission;
import com.bcfou.entity.Role;
import com.bcfou.entity.User;
import com.bcfou.util.MD5Util;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 19:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;
    @Test
//    @Transactional
    public void saveTest(){
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        user.setPassword( MD5Util.encrypt("admin", "123456").toString());
        user.setMail("498336692@qq.com");
        List<Role> roles = new ArrayList<>();

        List<Permission> permissions = new ArrayList<>();
        Permission permission = new Permission();
        permission.setId(1);
        permission.setAuthority("admin:*");
        permission.setUrl("/**");
        permissions.add(permission);
        Role role = new Role();
        role.setId(1);
        role.setName("admin");
        role.setDescription("超级管理员");
        role.setPermissions(permissions);
        roles.add(role);
        user.setRoles(roles);
        repository.save(user);
    }
    @Test
    public void findByUserName() {
        User user = repository.findByUserName("admin");
        List<Role> roles = user.getRoles();
        Set<Permission> permissionSet = new HashSet<>();
        Assert.assertNotEquals(null, user);
        Assert.assertNotEquals(null, roles);
    }
}