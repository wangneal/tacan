package com.bcfou.service;

import com.bcfou.entity.UrlSite;
import com.bcfou.entity.Visitor;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 13:29
 */
public interface UrlsiteByVisitorService {
    Visitor findNumberByUrlsiteId(int id);
    Integer getAllVisitors();
    List<UrlSite> findByNumber();
}
