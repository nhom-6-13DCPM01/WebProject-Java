package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.dao.CategoryRepository;
import com.webproject.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

}
