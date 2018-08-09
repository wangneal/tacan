package com.bcfou.repository;

import com.bcfou.entity.UrlSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 17:09
 */
public interface UrlSiteRepository extends JpaRepository<UrlSite, Integer> {

    UrlSite findBySitename(String sitename);

    List<UrlSite> findByStatus(Integer status);
}
