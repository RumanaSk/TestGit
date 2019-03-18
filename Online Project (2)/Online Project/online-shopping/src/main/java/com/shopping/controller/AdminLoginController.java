package com.shopping.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shopping.dto.AdminDto;
import com.shopping.service.AdminService;

@Controller
@SessionAttributes("admin")
public class AdminLoginController {
	@Autowired
	private AdminService service;

	@RequestMapping(path="/adminlogin", method = RequestMethod.POST)
       public String login(AdminDto dto, Map<String, Object> model) { {
		boolean isValidAdmin = service.login(dto);
		if(isValidAdmin) {
			model.put("admin", service);
			return "/confirmadmin.jsp";
		}else {
			return "redirect:/adminlogin.jsp";
		}
	}
 }
}