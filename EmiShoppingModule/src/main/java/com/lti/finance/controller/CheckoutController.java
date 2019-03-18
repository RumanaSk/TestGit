package com.lti.finance.controller;

import java.util.Date;

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
	@RequestMapping(value ="emi", method = RequestMethod.GET)
	public String checkEmiOptions(@RequestParam("cartTotal") int cartTotal,HttpSession session) {
			
		session.setAttribute("cartTotal",cartTotal);

		return "redirect:/checkout.jsp";
	
		}
	
	@RequestMapping(value ="payemi")
	public String payEmi(@RequestParam("sum") double monthlyEmi,HttpSession session) {
			System.out.println(" came in finally  ");
		session.setAttribute("sum",monthlyEmi);

		return "redirect:/payment2.jsp";
	
		}
	@RequestMapping(value = "emipayment", method = RequestMethod.GET)
	public String emiPayment(@RequestParam("card_id") int cardNumber,@RequestParam("cvv") int  cvv,@RequestParam("valid_upto") Date validity,HttpSession session) {
		session.setAttribute("card_id",cardNumber);
	  session.setAttribute("cvv",cvv);
		session.setAttribute("valid_upto",validity);
			return "redirect:/paymentSuccessfull.jsp";
		}
	
	@RequestMapping(value = "emipayment", method = RequestMethod.GET)
	public String emiPayment() {
		
		
			return "redirect:/paymentSuccessfull.jsp";
		}
	
	
	@RequestMapping(value = "pay", method = RequestMethod.GET)
	public String checkTotalOptions(@RequestParam("sum") String cartTotal,HttpSession session) {
			
		session.setAttribute("cartTotal",cartTotal);

		return "redirect:/checkout.jsp";
	
		}
	
}
