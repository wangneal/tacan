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

import static org.junit.Assert.*;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 17:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlSiteRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(UrlSiteRepositoryTest.class);
    @Autowired
    private UrlSiteRepository repository;
    @Test
    public void saveTest(){
        UrlSite urlSite = new UrlSite();
        urlSite.setSitename("编程否");
        urlSite.setSiteurl("http://www.bcfou.com");
        UrlSite result = repository.save(urlSite);
        Assert.assertNotEquals(null, result);
    }
    @Test
    public void getCategoryTest(){
        UrlSite urlSite = repository.findBySitename("编程否");
        log.info(urlSite.toString());
    }
}