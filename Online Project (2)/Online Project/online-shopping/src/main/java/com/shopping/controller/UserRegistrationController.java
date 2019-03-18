package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopping.dto.UserDto;
import com.shopping.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	public UserService registerService;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String login(UserDto registerDto) {

		registerService.add(registerDto);
		return "/confirmation.jsp";
	}
}
