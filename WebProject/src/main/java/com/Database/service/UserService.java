package com.Database.service;

import java.util.List;

import com.Database.entity.User;

public interface UserService {

	List<User> getListUser();

	User getUserByEmail(String email);
}
