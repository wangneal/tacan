package com.bcfou.repository;

import com.bcfou.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 21:45
 */
@Mapper
public interface RolePermissionRepository {
    @Select("select p.url,p.authority from t_permission p left join role_permission rp on(p.id=rp.p_id) left join t_role r on(rp.r_id=r.id) left join user_role ur on(r.id=ur.r_id) left join t_user u on(ur.u_id=u.id) where user_name=#{username}")
    List<Permission> findByUserName(String username);
}
