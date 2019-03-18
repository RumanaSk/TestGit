package com.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "checkout")

public class CheckoutController {

	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String paymentgateway() {
		return "redirect:/paymentgateway.jsp";
	}
	
	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public String checkTotalOptions(@RequestParam("sum") String cartTotal,HttpSession session) {
			
		session.setAttribute("cartTotal",cartTotal);

		return "redirect:/checkout.jsp";
	
		}
	
	
}
