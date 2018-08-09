package com.bcfou.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 用户表
 * @Author: 编程否
 * @Date: 2018/8/7 19:08
 */
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6303998311102986676L;
    @Id
    @GeneratedValue
    private Integer id;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    /** 邮箱 */
    private String mail;

    /** 与Role表多对多*/
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "u_id")}, inverseJoinColumns = {@JoinColumn(name = "r_id")})
    private List<Role> roles;
}
