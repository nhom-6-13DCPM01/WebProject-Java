package com.Controller.Admin.Order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Database.entity.Order;
import com.Database.service.OrderService;

@Controller
@RequestMapping("/Admin/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/Show")
	public String showOrder(Model model) {
		List<Order> orders = orderService.getAll(); 
		model.addAttribute("orders", orders);
		return "Admin/Order/showorders";
	}
}
