package com.bcfou.repository;

import com.bcfou.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 2:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlSite2CategoryRepositoryTest {
    @Autowired
    private UrlSite2CategoryRepository repository;
    @Test
    public void findBySiteName() {
        Category category = repository.findBySiteName("编程否");
        System.out.println(category.toString());
    }
}