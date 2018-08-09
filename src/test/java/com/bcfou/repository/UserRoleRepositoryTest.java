package com.bcfou.repository;

import com.bcfou.entity.Role;
import com.bcfou.service.UserRoleService;
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
 * @Date: 2018/8/7 21:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleRepositoryTest {
    @Autowired
    private UserRoleService service;
    @Test
    public void findByUserName() {
        List<Role> roleList = service.findByUserName("admin");
        System.out.println(roleList.toString());
        Assert.assertNotEquals(null,roleList);
    }
}