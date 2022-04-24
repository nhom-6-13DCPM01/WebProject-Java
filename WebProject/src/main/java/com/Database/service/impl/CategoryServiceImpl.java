package com.Database.service.impl;

import java.util.List;
import java.util.Optional;

import com.Database.repository.CategoryRepository;
import com.Database.service.CategoryService;
import com.Database.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void removeById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
   
  
	@Override
	public Optional<Category> getById(long id) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepository.findById(id);
        return category;
    }
}
