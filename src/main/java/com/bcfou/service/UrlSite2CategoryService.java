package com.bcfou.service;

import com.bcfou.entity.Category;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 2:33
 */
public interface UrlSite2CategoryService {
    Category findBySiteName(String sitename);
}
