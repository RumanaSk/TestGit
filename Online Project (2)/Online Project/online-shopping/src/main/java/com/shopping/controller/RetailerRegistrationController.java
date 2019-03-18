package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.dto.RetailerDto;
import com.shopping.service.RetailerService;



@Controller
public class RetailerRegistrationController {

	@Autowired
	public RetailerService retailerService;

	@RequestMapping(path = "/retailer", method = RequestMethod.POST)
	public String login(RetailerDto retailerDto) {

		retailerService.add(retailerDto);
		return "/confirmation.jsp";
	}
}