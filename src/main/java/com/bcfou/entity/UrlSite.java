package com.bcfou.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 网址表
 * @Author: 编程否
 * @Date: 2018/8/8 17:03
 */
@Entity
@Table(name = "urlsite")
@Data
public class UrlSite implements Serializable {
    private static final long serialVersionUID = 2372013797114968092L;
    //网址标识唯一
    @Id
    @GeneratedValue
    private Integer id;
    /** 网址名称 */
    private String sitename;
    /** 网址url */
    private String siteurl;
    /** 网址状态， 0待审核，1审核完成 */
    private Integer status = 0;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Category category;

    @OneToOne(optional = false, cascade = CascadeType.REFRESH, mappedBy = "urlSite")
    private Visitor visitor;
}
