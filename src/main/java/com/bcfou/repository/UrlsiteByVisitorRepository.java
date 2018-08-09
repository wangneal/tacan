package com.bcfou.repository;

import com.bcfou.entity.UrlSite;
import com.bcfou.entity.Visitor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 根据访问量排序urlsite
 * @Author: 编程否
 * @Date: 2018/8/9 13:11
 */
@Mapper
public interface UrlsiteByVisitorRepository {
    @Select("select v.id,v.number from visitor v left join urlsite u on(v.u_id=u.id) where u.id=#{id}")
    Visitor findNumberByUrlsiteId(int id);//根据url.id获取访问量
    @Select("select * from urlsite u left join  visitor v on (u.id=v.u_id) order by v.number desc")
    List<UrlSite> findByNumber();//根据访问量排序查询网址
    @Select("select sum(number) from visitor")
    Integer getAllVisitors();
}
