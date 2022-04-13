package com.webproject.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.tutorial.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
