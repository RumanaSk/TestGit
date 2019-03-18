package com.lti.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.finance.dto.RegisterDTO;
import com.lti.finance.service.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@Transactional
	public String Registeration(RegisterDTO registerDTO) {
		registerService.register(registerDTO);
		return "redirect:/welcome.jsp";
	}
}
