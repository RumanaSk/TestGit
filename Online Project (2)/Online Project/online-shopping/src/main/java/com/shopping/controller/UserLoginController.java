package com.shopping.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.dto.UserDto;
import com.shopping.entity.UserLoginCredentials;
import com.shopping.service.UserService;
//import com.sun.javafx.collections.MappingChange.Map;

@Controller
@SessionAttributes("user")
public class UserLoginController {

	@Autowired
	private UserService registerService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(UserDto registerDTO, Map<String, Object> model) {
	
		
		UserLoginCredentials credentials = registerService.login(registerDTO);
		if (credentials != null) {
			model.put("user", credentials);
			return "/confirm.jsp";
		} else {
			model.put("error", "Login Failed! Please Enter Valid Credentials");
			return "redirect:/login.jsp";
			
		}
		
	}
}




