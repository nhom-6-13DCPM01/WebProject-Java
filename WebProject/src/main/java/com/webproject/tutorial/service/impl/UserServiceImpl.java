package com.webproject.tutorial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.tutorial.dao.UserRepository;
import com.webproject.tutorial.entity.User;
import com.webproject.tutorial.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository ;

	@Override
	public List<User> getListUser() {
		List<User> list = userRepository.findAll();
		return list;
	}
	
	
}
