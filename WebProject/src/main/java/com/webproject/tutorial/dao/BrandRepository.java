package com.webproject.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.tutorial.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long>{

}
