package com.webproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {

	@GetMapping("/home")
	public String hello() {
		return "Client/home";
	}
}