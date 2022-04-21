package com.Controller.Client.ShoppingCart;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Database.entity.Order;
import com.Database.entity.User;
import com.Database.service.MyUserDetail;

@Controller
@RequestMapping("/Client/CheckOut")
public class CheckOutController {
	private String payway;
	private Order order;
	
	@GetMapping("/Show")
	public String index() {
		return "Client/ShoppingCart/checkout";
	}
	
	@PostMapping("/CheckLogin")
	public String checkLogin(@AuthenticationPrincipal MyUserDetail userDetails,@ModelAttribute("address")String address, @ModelAttribute("phone")String phone, HttpServletRequest request) {
		payway = request.getParameter("payment");
		User user = null;
		if(userDetails !=null){
			user = userDetails.getUser();
			order = new Order(null, address, phone, "CHƯA THANH TOÁN", new Date(System.currentTimeMillis()), null, null, user);
		}
		if(user == null){
			return "redirect:/Authentication/Login";
		}
		return "redirect:/Client/CheckOut/ConfirmTheWayToPay";
	}
	
	@GetMapping("/ConfirmTheWayToPay")
	public String redirectPayment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		if(payway == "paypal")
			return "";
		else
			return "";
	}
}
