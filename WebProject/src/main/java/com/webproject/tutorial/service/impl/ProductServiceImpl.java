package com.webproject.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.tutorial.dao.ProductRepository;
import com.webproject.tutorial.service.ProductService;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

}
