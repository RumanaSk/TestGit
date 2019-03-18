
package com.lti.finance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.finance.entity.AdminProducts;
import com.lti.finance.entity.Item;
import com.lti.finance.entity.Order;
import com.lti.finance.service.AdminProductService;


@Controller
@RequestMapping(value = "cart")
public class CartController {
	@Autowired
	AdminProductService service;

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "cart/index2.jsp";
	}

	@RequestMapping(value = "buy", method = RequestMethod.GET)
	public String buy(@RequestParam("pid") int id, HttpSession session) {

		
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			
		AdminProducts cartItem =service.find(id);
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

	@RequestMapping(value="confirm")
	public String confirm(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		System.out.println(cart);
		Order order = transactionService.placeOrder(cart);
		session.setAttribute("order", order);
		return "/address.jsp";
	}

	
	
	@RequestMapping(value="placeOrder",method = RequestMethod.GET)
	public String placeOrder(HttpSession session) {
		List<Order>order=(List<Order>)session.getAttribute("order");
		System.out.println("order");
		session.setAttribute("order", order);
		return  "/thankyou.jsp";
	}
	
	
	
	
}