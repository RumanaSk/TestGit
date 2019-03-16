package com.lti.finance.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.finance.dto.AdminDTO;
import com.lti.finance.entity.Admin;
import com.lti.finance.service.AdminService;

@Controller
@RequestMapping(value = "product")
public class ProductController {

	/*@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductModel productModel = new ProductModel();
		modelMap.put("products", productModel.findAll());
		return "/index.jsp";*/
		@Autowired
		private AdminService adminService;
		
		@RequestMapping(path="/uploadproducts", method=RequestMethod.GET)
		public String register(AdminDTO adminDTO, Map<String, Object> model) {
			adminService.addProducts(adminDTO);
	       model.put("prodcutDetails", adminDTO);
	   	return "redirect:/showproducts.jsp";
		}
		
		@RequestMapping(path="/list", method=RequestMethod.GET)
		public String list(Map<String, Object> model) {
			List<Admin> list = adminService. getAllProducts();
			model.put("listOfProducts", list);
			return "/index.jsp";
		}
	
	
	}
