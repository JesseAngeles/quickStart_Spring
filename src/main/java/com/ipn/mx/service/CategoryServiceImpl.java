package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.model.entity.Category;
import com.ipn.mx.model.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) repository.findAll(); 
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Category save(Category category) {
        return repository.save(category);
    } 

}
