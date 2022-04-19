package com.Database.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.Database.entity.User;
import com.Database.repository.UserRepository;
import com.Database.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository ;

	@Autowired
    private PasswordEncoder passwordEncoder;
     
    @Autowired
    private JavaMailSender mailSender;

	@Override
	public List<User> getListUser() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.getUserByEmail(email);
		return user;
	}

	@Override
	public void register(User user, String url) throws UnsupportedEncodingException, MessagingException {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			 
			String randomCode = RandomString.make(64);
			user.setOtpCode(randomCode);
			user.setEnable(false);
			 
			userRepository.save(user);
			 
			sendVerificationEmail(user, url);
		
	}

	@Override
	public void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException {
			String toAddress = user.getEmail();
			String fromAddress = "shopjavaweb@gmail.com";
			String senderName = "Shop Java Web Welcome";
			String subject = "Please verify your registration";
			String content = "Dear [[name]],<br>"
					+ "Please click the link below to verify your registration:<br>"
					+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
					+ "Thank you,<br>"
					+ "Your company name.";
			 
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			 
			helper.setFrom(fromAddress, senderName);
			helper.setTo(toAddress);
			helper.setSubject(subject);
			 
			content = content.replace("[[name]]", user.getDisplayName());
			String verifyURL = siteURL + "/Authentication/verify?code=" + user.getOtpCode();
			 
			content = content.replace("[[URL]]", verifyURL);
			 
			helper.setText(content, true);
			 
			mailSender.send(message);
		}

	@Override
	public boolean verify(String verificationCode) {
		User user = userRepository.findByVerificationCode(verificationCode);
    if (user == null || user.isEnable()) {
        return false;
    } else {
        user.setOtpCode(null);
        user.setEnable(true);
		user.setRole("ROLE_USER");
        userRepository.save(user);
         
        return true;
    }
	}	
}
