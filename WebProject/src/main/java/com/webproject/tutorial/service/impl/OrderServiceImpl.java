package com.webproject.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.webproject.tutorial.dao.OrderRepository;
import com.webproject.tutorial.service.OrderService;

public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
}
