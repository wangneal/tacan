package com.bcfou.service;

import com.bcfou.entity.UrlSite;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 20:07
 */
public interface Category2UrlSiteService {
    List<UrlSite> findByCategoryName(String name);

}
