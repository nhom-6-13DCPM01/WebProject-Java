package com.webproject.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.tutorial.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
