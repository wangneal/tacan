package com.bcfou.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 角色表
 * @Author: 编程否
 * @Date: 2018/8/7 19:13
 */
@Entity
@Table(name = "t_role")
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -3081500327698752255L;

    @Id
    @GeneratedValue
    private Integer id;
    /** 角色名 */
    private String name;
    /** 描述 */
    private String description;

    /** 与permission表多对多 */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_permission", joinColumns = {@JoinColumn(name = "r_id")}, inverseJoinColumns = {@JoinColumn(name = "p_id")})
    private List<Permission> permissions;
}
