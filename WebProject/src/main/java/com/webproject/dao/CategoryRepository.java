package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
