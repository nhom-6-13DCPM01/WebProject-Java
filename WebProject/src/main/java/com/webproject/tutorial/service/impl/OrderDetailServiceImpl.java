package com.webproject.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.tutorial.dao.OrderDetailRepository;
import com.webproject.tutorial.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;
}
