package com.bcfou.service.impl;

import com.bcfou.entity.UrlSite;
import com.bcfou.repository.Category2UrlSiteRepository;
import com.bcfou.service.Category2UrlSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 20:08
 */
@Service
public class Category2UrlSiteServiceImpl implements Category2UrlSiteService {
    @Autowired
    private Category2UrlSiteRepository repository;
    @Override
    public List<UrlSite> findByCategoryName(String name) {
        return repository.findByCategoryName(name);
    }
}
