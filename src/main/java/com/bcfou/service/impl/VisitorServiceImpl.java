package com.bcfou.service.impl;

import com.bcfou.entity.Visitor;
import com.bcfou.repository.VisitorRepository;
import com.bcfou.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 编程否
 * @Date: 2018/8/9 13:42
 */
@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    private VisitorRepository repository;
    @Override
    public Visitor save(Visitor visitor) {
        return repository.save(visitor);
    }
}
