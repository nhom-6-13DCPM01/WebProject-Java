package com.Database.service.impl;

import java.util.List;

import com.Database.entity.User;
import com.Database.repository.UserRepository;
import com.Database.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
