package com.bcfou.repository;

import com.bcfou.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 通过网址名称查询分类
 * @Author: 编程否
 * @Date: 2018/8/8 17:44
 */
@Mapper
public interface UrlSite2CategoryRepository {

    @Select("select c.id,c.name from category c left join urlsite u on (c.id=u.c_id) where u.sitename=#{sitename}")
    Category findBySiteName(String sitename);
}
