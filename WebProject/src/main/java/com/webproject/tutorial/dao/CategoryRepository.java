package com.webproject.tutorial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webproject.tutorial.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
