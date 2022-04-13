package com.webproject.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.tutorial.dao.BrandRepository;
import com.webproject.tutorial.service.BrandService;

public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
}
