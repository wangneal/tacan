package com.bcfou.repository;

import com.bcfou.entity.Permission;
import com.bcfou.service.RolePermissionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 22:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RolePermissionRepositoryTest {
    @Autowired
    private RolePermissionService service;
    @Test
    public void findByUserName() {
        List<Permission> permissions = service.findByUserName("admin");
        System.out.println(permissions.toString());
        Assert.assertNotEquals(null, permissions);
    }
}