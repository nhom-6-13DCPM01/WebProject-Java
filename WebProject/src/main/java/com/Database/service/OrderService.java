package com.Database.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Database.entity.Order;
import com.Database.entity.OrderDetail;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getAll();

	Page<Order> getAllPage(Pageable pageable);

	Order getById(long id);

	List<OrderDetail> getByIdList(long id);

}
