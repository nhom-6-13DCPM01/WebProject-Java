package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{

}
