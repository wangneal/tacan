package com.bcfou.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 网站信息
 * @Author: 编程否
 * @Date: 2018/8/8 16:54
 */
@Entity
@Table(name = "website")
@Data
public class WebSite implements Serializable {

    private static final long serialVersionUID = 5557410012625697050L;
    @Id
    @GeneratedValue
    private Integer id;
    /** 网站名称 */
    private String webname;
    /** 网站描述 */
    private String webdescribe;

}
