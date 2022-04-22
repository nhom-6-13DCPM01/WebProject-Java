package com.Controller.Admin.User;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.Database.entity.User;
import com.Database.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Admin/User")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/List")
	public String listUser(@RequestParam Integer page,@RequestParam Integer size,Model model) {
		Page<User> list = userService.getListUser(page, size);
		model.addAttribute("list",list);
		int totalPages = list.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		return "fragments/Admin/usertbody::usertbody";
	}

	@GetMapping("/ViewUser")
	public String viewUser(){
		return "Admin/User/user";
	}

	@GetMapping("/Update")
	public String updateUser(ModelMap model) {

		return "Admin/User/userupdate";
	}

	@GetMapping("/Delete")
	public String deleteUser(ModelMap model) {

		return "redirect:/Admin/User/List";
	}
	
	@GetMapping("/Detail")
	public String detailUser(ModelMap model) {

		return "Admin/User/userdetail";
	}
}
