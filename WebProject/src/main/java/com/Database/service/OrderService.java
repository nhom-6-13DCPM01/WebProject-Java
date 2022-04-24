package com.Database.service;

import java.util.List;

import com.Database.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getAll();

}
