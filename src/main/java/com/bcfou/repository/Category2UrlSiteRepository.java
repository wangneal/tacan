package com.bcfou.repository;

import com.bcfou.entity.UrlSite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 分类名查询网址
 * @Author: 编程否
 * @Date: 2018/8/8 17:10
 */
@Mapper
public interface Category2UrlSiteRepository {

    @Select("select u.id, u.sitename, u.siteurl, u.status from urlsite u left join category c on (u.category_id=c.id) where c.name=#{name}")
    List<UrlSite> findByCategoryName(String name);

    @Select("select u.id, u.sitename, u.siteurl, u.status from urlsite u left join category c on (u.category_id=c.id) where c.id=#{id} limit 0, 6")
    List<UrlSite> findByCategoryId(Integer id);
}
