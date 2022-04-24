package com.Database.service.impl;

import com.Database.entity.Order;
import com.Database.repository.OrderRepository;
import com.Database.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
