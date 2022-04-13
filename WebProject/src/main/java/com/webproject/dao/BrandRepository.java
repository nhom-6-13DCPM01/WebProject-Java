package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long>{

}
