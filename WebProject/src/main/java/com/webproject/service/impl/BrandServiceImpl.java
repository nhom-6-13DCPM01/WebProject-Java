package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.dao.BrandRepository;
import com.webproject.service.BrandService;

public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
}
