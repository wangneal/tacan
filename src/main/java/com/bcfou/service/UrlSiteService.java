package com.bcfou.service;

import com.bcfou.entity.UrlSite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 1:30
 */
public interface UrlSiteService {

    Page<UrlSite> findAll(Pageable pageable);

    UrlSite findById(Integer id);

    UrlSite save(UrlSite urlSite);

    UrlSite findBySitename(String sitename);

    List<UrlSite> findByStatus(Integer status);

    void deleteById(Integer id);
}
