package com.bcfou.repository;

import com.bcfou.entity.WebSite;
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
 * @Date: 2018/8/8 17:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSiteRepositoryTest {
    @Autowired
    private WebSiteRepository repository;
    @Test
    public void saveTest(){
        WebSite webSite = new WebSite();
        webSite.setWebname("TACAN网址导航");
        webSite.setWebdescribe("专注精准导航系统");
        WebSite result = repository.save(webSite);
        Assert.assertNotEquals(null, result);
    }
    @Test
    public void getOne(){
        List<WebSite> webSites = repository.findAll();
        WebSite webSite = webSites.get(0);
        System.out.println(webSite.toString());
    }
}