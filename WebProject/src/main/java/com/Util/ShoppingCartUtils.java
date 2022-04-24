package com.Util;

import org.springframework.beans.factory.annotation.Autowired;

import com.Database.entity.Order;

public class ShoppingCartUtils {
	@Autowired
	private static Order order;
	
	public static void setOrder(Order order) {
		ShoppingCartUtils.order = order;
	}
	public static Order getOrder() {
		return ShoppingCartUtils.order;
	}
}
