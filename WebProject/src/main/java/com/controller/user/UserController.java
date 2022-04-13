package com.controller.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webproject.entity.User;
import com.webproject.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/List")
	public String viewUser(ModelMap model) {
		List<User> list= userService.getListUser();
		model.addAttribute("list",list);
		return "Admin/listuser";
	}
}
