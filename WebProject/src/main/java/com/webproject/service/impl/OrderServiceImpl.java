package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.dao.OrderRepository;
import com.webproject.service.OrderService;

public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
}
