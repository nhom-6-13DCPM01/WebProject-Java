package com.Database.service.impl;

import com.Database.repository.OrderDetailRepository;
import com.Database.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;
}
