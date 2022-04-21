package com.Controller.Client.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.Config.PaypalPaymentIntent;
import com.Config.PaypalPaymentMethod;
import com.Database.service.IPaypalService;
import com.Util.PaypalUtils;

@Controller
@RequestMapping("/Client/Payment")
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "Client/Payment/SuccessPaypal";
	public static final String URL_PAYPAL_CANCEL = "Client/Payment/CancelPaypal";
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private IPaypalService paypalService;
	
	//Paypal
	@GetMapping("/PayByPaypal")
	public String payByPaypal(HttpServletRequest request){
		String cancelUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		
		HttpSession session = request.getSession();
		double price = (double) session.getAttribute("amount");
		
		try {
			Payment payment = paypalService.createPayment(
					price,
					"USD",
					PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale,
					"payment description",
					cancelUrl,
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/Client/Payment/PayByPaypal";
	}
	
	@GetMapping("/CancelPaypal")
	public String cancelPaypal(){
		return "cancel";
	}
	
	@GetMapping("/SuccessPaypal")
	public String successPaypal(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "Cilent/Payment/paysuccess";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/Client/Payment/PayByPaypal";
	}
	
	//PayByMoney
	@GetMapping("/PayCash")
	public String payByMoney() {
		return "";
	}
	
	@GetMapping("/CancelPayCash")
	public String cancelPayMoney() {
		return "";
	}
	
	@PostMapping("/SuccessPayCash")
	public String successPayMoney() {
		return "Cilent/Payment/paysuccess";
	}
}
