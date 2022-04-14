package com.Database.service.impl;

import com.Database.repository.BrandRepository;
import com.Database.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository brandRepository;
	
}
