package com.lti.finance.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;
import com.lti.finance.service.LoginService;

@Controller
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(LoginDTO loginDTO, Map<String, Object> model,HttpSession session) {

		Register reg = loginService.login(loginDTO);
		if (reg != null) {
			model.put("user", reg);
			session.setAttribute("user", reg);
			return "/homepage.jsp";

		} else {

			return "redirect:/login.jsp";
          
            
		}
	}
}
