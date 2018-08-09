package com.bcfou.repository;

import com.bcfou.entity.UrlSite;
import com.bcfou.entity.Visitor;
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
 * @Date: 2018/8/9 13:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlsiteByVisitorRepositoryTest {
   @Autowired
   private UrlsiteByVisitorRepository repository;
    @Test
    public void findNumberByUrlsiteId() {

        Visitor visitor = repository.findNumberByUrlsiteId(9);
        System.out.println(visitor.toString());
    }

    @Test
    public void findByNumber() {

        List<UrlSite> sites = repository.findByNumber();
        Assert.assertNotEquals(null, sites);
        System.out.println(sites.toString());
    }
}