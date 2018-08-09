package com.bcfou.service;

import com.bcfou.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 19:10
 */
public interface CategoryService {
    Category save(Category category);
    void deleteById(Integer id);
    List<Category> findAll();
    Page<Category> findAll(Pageable pageable);
    Category findById(Integer id);
}
