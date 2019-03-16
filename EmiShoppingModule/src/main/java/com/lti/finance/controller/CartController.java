package com.lti.finance.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.finance.dto.PrimaryAccountDTO;
import com.lti.finance.dto.SecondaryAccountDTO;
import com.lti.finance.entity.Account;
import com.lti.finance.entity.Admin;
import com.lti.finance.entity.Item;
import com.lti.finance.model.ProductModel;
import com.lti.finance.service.AdminService;
import com.lti.finance.service.PaymentGatewayService;

@Controller
@RequestMapping(value = "cart")
public class CartController {
	@Autowired
	AdminService service;

	@Autowired
	private PaymentGatewayService paymentGatewayService;
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "cart/index2.jsp";
	}

	@RequestMapping(value = "buy", method = RequestMethod.GET)
	public String buy(@RequestParam("pid") int id, HttpSession session) {

		
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			
		Admin cartItem =service.find(id);
			Item item =new Item(cartItem, 1);
			cart.add(item);
			session.setAttribute("cart", cart);

		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = this.exists(id, cart);
		
			if (index == -1) {		
				cart.add(new Item(service.find(id), 1));}
		  else {		
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);}
			session.setAttribute("cart", cart);
		  }
		return "redirect:/index2.jsp";
	}

	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String remove(@RequestParam("pid") int id,HttpSession session) {
		
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(id, cart);
	
		
		if (index == 1) {		
			cart.remove(index);}
		else {
			int quantity = cart.get(index).getQuantity() - 1;
			cart.get(index).setQuantity(quantity);}
		session.setAttribute("cart", cart);
		return "redirect:/index2.jsp";
	}

	private int exists(int id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId()==(id)) {
				return i;
			}
		}
		return -1;
	}

	
	
	
	
}