package com.bcfou.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 12:59
 */
@Entity
@Table(name = "visitor")
@Data
public class Visitor implements Serializable {
    private static final long serialVersionUID = 5433165170401635958L;

    @Id
    @GeneratedValue
    private Integer id;
    /** 访问次数 */
    private Integer number;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "u_id", unique = true)
    private UrlSite urlSite;
}
