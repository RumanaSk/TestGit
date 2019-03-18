package com.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.dto.ProductDto;
import com.shopping.dto.UserDto;
import com.shopping.entity.Product;
import com.shopping.entity.User;
import com.shopping.service.ProductService;
import com.shopping.service.UserService;

@SessionAttributes("productDetails")

@Controller
@RequestMapping(value = "product")
public class ProductController {

	/*@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductModel productModel = new ProductModel();
		modelMap.put("products", productModel.findAll());
		return "/index.jsp";*/
		@Autowired
		private ProductService service;
		
		@RequestMapping(path="/uploadproducts", method=RequestMethod.GET)
		public String register(ProductDto dto, Map<String, Object> model) {
			service.addProducts(dto);
	       model.put("productDetails", dto);
	   	return "redirect:/showproducts.jsp";
		}
		
		@RequestMapping(path="/list", method=RequestMethod.GET)
		public String list(Map<String, Object> model) {
			List<Product> list = service.getAllProducts();
			model.put("listOfProducts", list);
			return "/index.jsp";
		}
	
	
	}
