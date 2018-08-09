package com.bcfou.repository;

import com.bcfou.entity.Visitor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 13:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitorRepositoryTest {
    @Autowired
    private VisitorRepository repository;
    @Test
    public void saveTest(){
        Visitor visitor = new Visitor();
        visitor.setNumber(100000);
        Visitor result = repository.save(visitor);
        Assert.assertNotEquals(null, result);
    }
}