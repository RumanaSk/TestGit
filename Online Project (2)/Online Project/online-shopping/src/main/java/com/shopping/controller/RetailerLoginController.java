package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.dto.RetailerDto;
import com.shopping.service.RetailerService;



@Controller
public class RetailerLoginController {

	@Autowired
	private RetailerService retailerService;

	@RequestMapping(path = "/retailerlogin", method = RequestMethod.POST)
	public String login(RetailerDto retailerDTO) {
		boolean isValid = retailerService.login(retailerDTO);
		if (isValid)
			{return "/confirm.jsp";}
		else
			{return "redirect:/loginfail.jsp";}

		// loginService.login(loginDTO);
		// return"/confirmation.jsp";
	}
}
