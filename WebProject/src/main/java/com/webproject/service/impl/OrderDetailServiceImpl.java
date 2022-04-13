package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.dao.OrderDetailRepository;
import com.webproject.service.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;
}
