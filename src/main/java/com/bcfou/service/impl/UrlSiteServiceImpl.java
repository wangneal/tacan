package com.bcfou.service.impl;

import com.bcfou.entity.UrlSite;
import com.bcfou.repository.UrlSiteRepository;
import com.bcfou.service.UrlSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 1:35
 */
@Service
public class UrlSiteServiceImpl implements UrlSiteService {
    @Autowired
    private UrlSiteRepository repository;
    @Override
    public Page<UrlSite> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public UrlSite findById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public UrlSite save(UrlSite urlSite) {
        return repository.save(urlSite);
    }

    @Override
    public UrlSite findBySitename(String sitename) {
        return repository.findBySitename(sitename);
    }

    @Override
    public List<UrlSite> findByStatus(Integer status) {
        return repository.findByStatus(status);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
