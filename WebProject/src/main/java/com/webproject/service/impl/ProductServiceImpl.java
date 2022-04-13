package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.dao.ProductRepository;
import com.webproject.service.ProductService;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;

}
