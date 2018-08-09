package com.bcfou.service.impl;

import com.bcfou.entity.Category;
import com.bcfou.repository.UrlSite2CategoryRepository;
import com.bcfou.service.UrlSite2CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 2:33
 */
@Service
public class UrlSite2CategoryServiceImpl implements UrlSite2CategoryService {
    @Autowired
    private UrlSite2CategoryRepository repository;
    @Override
    public Category findBySiteName(String sitename) {
        return repository.findBySiteName(sitename);
    }
}
