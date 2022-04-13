package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
