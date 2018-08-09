package com.bcfou.service.impl;

import com.bcfou.entity.WebSite;
import com.bcfou.repository.WebSiteRepository;
import com.bcfou.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 21:22
 */
@Service
public class WebSiteServiceImpl implements WebSiteService {
    @Autowired
    private WebSiteRepository repository;

    @Override
    public List<WebSite> findAll() {
        return repository.findAll();
    }

    @Override
    public WebSite save(WebSite webSite) {
        return repository.save(webSite);
    }
}
