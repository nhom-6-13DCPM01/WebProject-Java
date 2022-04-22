package com.Database.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.Database.entity.User;

import org.springframework.data.domain.Page;

public interface UserService {

	Page<User> getListUser(Integer page,Integer size);

	User getUserByEmail(String email);

	void register(User user, String url) throws UnsupportedEncodingException, MessagingException;

	void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

	boolean verify(String verificationCode);
}
