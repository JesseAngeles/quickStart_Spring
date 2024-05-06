package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.model.entity.Category;

public interface CategoryService {
    public List<Category> findAll();
    public Category findById(Long id);
    public void deleteById(Long id);
    public Category save(Category category);
}
