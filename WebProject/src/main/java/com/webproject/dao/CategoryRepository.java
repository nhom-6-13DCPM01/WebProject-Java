package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

}
