package com.lti.finance.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.finance.dto.AdminProductDTO;
import com.lti.finance.entity.AdminProducts;
import com.lti.finance.service.AdminProductService;

@Controller
@RequestMapping(value = "product")
public class ProductController {

		@Autowired
		private AdminProductService adminService;
		
		@RequestMapping(path="/uploadproducts", method=RequestMethod.GET)
		public String register(AdminProductDTO adminDTO, Map<String, Object> model) {
			adminService.addProducts(adminDTO);
	       model.put("prodcutDetails", adminDTO);
	   	return "redirect:/showproducts.jsp";
		}
		
		@RequestMapping(path="/list", method=RequestMethod.GET)
		public String list(Map<String, Object> model) {
			List<AdminProducts> list = adminService. getAllProducts();
			model.put("listOfProducts", list);
			return "/productpage.jsp";
		}
	
	
	}
