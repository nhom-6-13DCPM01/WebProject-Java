package com.webproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
