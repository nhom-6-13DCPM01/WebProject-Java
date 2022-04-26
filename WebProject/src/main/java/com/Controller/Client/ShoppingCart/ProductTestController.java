package com.Controller.Client.ShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Database.service.IShoppingCartService;
import com.Database.service.IThinhProductService;

@Controller
@RequestMapping("/Client/ProductTest")
public class ProductTestController {
	@Autowired
	IThinhProductService iThinhProductService;
	@Autowired
	IShoppingCartService shoppingCartService;
	
	@GetMapping("/Show")
	public String showProduct(Model model) {
		model.addAttribute("products", iThinhProductService.getAll());
		return "Client/ShoppingCart/product-test";
	}
}
