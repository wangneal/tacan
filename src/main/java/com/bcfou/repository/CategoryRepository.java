package com.bcfou.repository;

import com.bcfou.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 17:09
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
