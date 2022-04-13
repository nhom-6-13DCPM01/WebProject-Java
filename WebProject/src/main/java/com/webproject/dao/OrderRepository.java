package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

}
