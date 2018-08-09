package com.bcfou.repository;

import com.bcfou.entity.Role;
import com.bcfou.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 20:31
 */
@Mapper
public interface UserRoleRepository{
    @Select("select r.id, r.name, r.description from t_role r left join user_role ur on(r.id=ur.r_id) left join t_user u on(ur.u_id=u.id) where u.user_name= #{username}")
    List<Role> findByUserName(String userName);
}
