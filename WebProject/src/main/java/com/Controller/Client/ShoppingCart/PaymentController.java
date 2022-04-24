package com.Controller.Client.ShoppingCart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.Config.PaypalPaymentIntent;
import com.Config.PaypalPaymentMethod;
import com.Database.DTO.CartItem;
import com.Database.entity.Order;
import com.Database.entity.OrderDetail;
import com.Database.entity.User;
import com.Database.service.IPaypalService;
import com.Database.service.IShoppingCartService;
import com.Database.service.OrderDetailService;
import com.Database.service.OrderService;
import com.Util.PaypalUtils;

@Controller
@RequestMapping("/Client/Payment")
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "Client/Payment/SuccessPaypal";
	public static final String URL_PAYPAL_CANCEL = "Client/Payment/CancelPay";
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private IPaypalService paypalService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailService orderDetailService;
	@Autowired
	private IShoppingCartService cartService;

	// PayByMoney
	@GetMapping("/PayCash")
	public String payByMoney() {
		return "Client/Payment/paycash";
	}
	
	@GetMapping("/SuccessPayCash")
	public String successPayMoney() {
		return "Client/Payment/paysuccess";
	}
	
	@GetMapping("/Recieve")
	public String recieveMoney(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getRole().equals("ROLE_ADMIN")) {
			saveAllToDatabase(request, "ĐÃ THANH TOÁN");
			return "redirect:/Client/Payment/SuccessPayCash";
		}
		return "redirect:/Client/Payment/PayCash";
	}

	@GetMapping("/Delivery")
	public String delivery(HttpServletRequest request) {
		saveAllToDatabase(request, "CHƯA THANH TOÁN");
		return "redirect:/Client/Payment/SuccessPayCash";
	}

	// Paypal
	@GetMapping("/PayByPaypal")
	public String payByPaypal(HttpServletRequest request) {
		String cancelUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		
		HttpSession session = request.getSession();
		double price = (double) session.getAttribute("amount");
		try {
			Payment payment = paypalService.createPayment(
					PaypalUtils.chuyenDoiTienVietThanhDola(price), 
					"USD",
					PaypalPaymentMethod.paypal, 
					PaypalPaymentIntent.sale, 
					"payment description", 
					cancelUrl, successUrl);
			for (Links links : payment.getLinks()) {
				if (links.getRel().equals("approval_url")) {
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/Client/CheckOut/Show";
	}

	@GetMapping("/SuccessPaypal")
	public String successPaypal(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,
			HttpServletRequest request) {
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if (payment.getState().equals("approved")) {
				saveAllToDatabase(request, "ĐÃ THANH TOÁN");
				return "Client/Payment/paysuccess";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/Client/CheckOut/Show";
	}

	@GetMapping("/CancelPay")
	public String cancelPayMoney() {
		return "Client/Payment/cancelpay";
	}

	@GetMapping("/ContinueBuying")
	public String continueBuying(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("CheckLogin");
		return "redirect:/Home";
	}

	@GetMapping("/RemoveSession")
	public String removeSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
		cartService.clear();
		session.removeAttribute("sizeCart");
		session.removeAttribute("amountVN");
		session.removeAttribute("amount");
		session.removeAttribute("phone");
		session.removeAttribute("address");
		session.removeAttribute("CheckLogin");
		return "redirect:/Home";
	}
	
	//Phần ngoài luồng
	public Collection<OrderDetail> addOrderDetail(Collection<CartItem> cartItem, Order order) {
		Collection<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		for (CartItem item : cartItem) {
			OrderDetail orderDetail = orderDetailService.saveOrderDetail(
					new OrderDetail(null, item.getQuantity(), item.getPrice(), order, item.getProduct()));
			orderDetails.add(orderDetail);
		}
		return orderDetails;
	}

	@SuppressWarnings("unchecked")
	public void saveAllToDatabase(HttpServletRequest request, String status) {
		HttpSession session = request.getSession();
		Collection<CartItem> cart = (Collection<CartItem>) session.getAttribute("cart");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
		User user = (User) session.getAttribute("user");
		
		Order order = new Order(null, address, phone, status, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 100000), null, user);
		Order orderSaved = orderService.saveOrder(order);
		addOrderDetail(cart, orderSaved);
	}
}
