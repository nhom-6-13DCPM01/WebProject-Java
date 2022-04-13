package com.webproject.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.tutorial.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
