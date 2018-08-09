package com.bcfou.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 网址分类
 * @Author: 编程否
 * @Date: 2018/8/8 17:00
 */
@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {

    private static final long serialVersionUID = 3533015342344042720L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<UrlSite> urlSites;
}
