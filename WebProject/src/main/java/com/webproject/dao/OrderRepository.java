package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
