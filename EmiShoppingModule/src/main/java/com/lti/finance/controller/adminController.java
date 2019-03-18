package com.lti.finance.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.finance.dto.adminDTO;
import com.lti.finance.service.adminService;

@Controller
@SessionAttributes("user")
public class adminController {
	@Autowired
	private adminService serv;

	@RequestMapping(path="/admin", method = RequestMethod.POST)
       public String login(adminDTO adminloginDTO, Map<String, Object> model) { {
		boolean isValidAdmin = serv.login(adminloginDTO);
		if(isValidAdmin) {
			model.put("user", serv);
			return "/showusers.jsp";
		}else {
			return "redirect:/loginForm.jsp";
		}
	}
 }
}