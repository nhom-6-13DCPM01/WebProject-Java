package com.Database.service.impl;

import java.util.Optional;
import java.util.List;

import com.Database.entity.Product;
import com.Database.repository.ProductRepository;
import com.Database.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
}
