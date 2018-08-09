package com.bcfou.service.impl;

import com.bcfou.entity.Category;
import com.bcfou.repository.CategoryRepository;
import com.bcfou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 编程否
 * @Date: 2018/8/8 19:11
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return repository.getOne(id);
    }
}
