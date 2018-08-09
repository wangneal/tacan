package com.bcfou.repository;

import com.bcfou.entity.Category;
import com.bcfou.entity.UrlSite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 17:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repository;
    @Test
    public void saveTest(){
        Category category = new Category();
        category.setName("博客");
        UrlSite urlSite = new UrlSite();
        urlSite.setSitename("croe中文网");
        urlSite.setSiteurl("www.croecn.com");
        List<UrlSite> urlSites = new ArrayList<>();
        category.setUrlSites(urlSites);
        Category result = repository.save(category);

        Assert.assertNotEquals(null, result);
    }
}