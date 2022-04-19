package com.Database.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import com.Database.entity.User;

public interface UserService {

	List<User> getListUser();

	User getUserByEmail(String email);

	void register(User user, String url) throws UnsupportedEncodingException, MessagingException;

	void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

	boolean verify(String verificationCode);
}
