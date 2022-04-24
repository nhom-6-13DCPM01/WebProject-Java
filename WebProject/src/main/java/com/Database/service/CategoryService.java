package com.Database.service;

import java.util.List;
import java.util.Optional;

import com.Database.service.CategoryService;
import com.Database.entity.Category;

public interface CategoryService {
    public List<Category> getAll();
    public List<Category> findAll();

    public Optional<Category> getById(long id);

    public Category save(Category category);

    public void remove(Category category);

    public void removeById(Long Id);

  
    
}
