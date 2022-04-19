package com.Controller.Admin.User;

import java.util.List;

import com.Database.entity.User;
import com.Database.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Admin/User")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/List")
	public String viewUser(ModelMap model) {
		List<User> list= userService.getListUser();
		model.addAttribute("list",list);
		return "Admin/User/user";
	}
	
}
