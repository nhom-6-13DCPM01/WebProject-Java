package com.webproject.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.tutorial.dao.CategoryRepository;
import com.webproject.tutorial.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

}
