package com.bcfou.repository;

import com.bcfou.entity.UrlSite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 17:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Category2UrlSiteRepositoryTest {
    @Autowired
    private Category2UrlSiteRepository repository;
    private static final Logger log = LoggerFactory.getLogger(Category2UrlSiteRepositoryTest.class);
    @Test
    public void findByCategoryName() {
        List<UrlSite> urlSites = repository.findByCategoryName("博客");
        log.info("查到数据："+urlSites.toString());
        Assert.assertNotEquals(null, urlSites);
    }

    @Test
    public void findByCategoryId(){
        List<UrlSite> urlSites = repository.findByCategoryId(7);
        System.out.println(urlSites.toString());
    }
}