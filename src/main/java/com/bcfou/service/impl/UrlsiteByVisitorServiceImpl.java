package com.bcfou.service.impl;

import com.bcfou.entity.UrlSite;
import com.bcfou.entity.Visitor;
import com.bcfou.repository.UrlsiteByVisitorRepository;
import com.bcfou.service.UrlsiteByVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 13:30
 */
@Service
public class UrlsiteByVisitorServiceImpl implements UrlsiteByVisitorService {
    @Autowired
    private UrlsiteByVisitorRepository repository;
    @Override
    public Visitor findNumberByUrlsiteId(int id) {
        return repository.findNumberByUrlsiteId(id);
    }

    @Override
    public Integer getAllVisitors() {
        return repository.getAllVisitors();
    }

    @Override
    public List<UrlSite> findByNumber() {
        return repository.findByNumber();
    }
}
