package com.bcfou.service;

import com.bcfou.entity.WebSite;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 21:21
 */

public interface WebSiteService {
    List<WebSite> findAll();
    WebSite save(WebSite webSite);
}
