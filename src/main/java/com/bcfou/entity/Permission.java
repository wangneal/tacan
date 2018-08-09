package com.bcfou.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: 编程否
 * @Date: 2018/8/7 19:18
 */
@Entity
@Table(name = "t_permission")
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 3851026445777522743L;
    @Id
    @GeneratedValue
    private Integer id;
    /** 权限值 */
    private String authority;
    /** url */
    private String url;
}
