package com.lti.finance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.finance.dto.ForgotPasswordDTO;
import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;
import com.lti.finance.service.ForgotPasswordService;
import com.lti.finance.service.LoginService;
@Controller
public class ForgotPasswordController {
	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@RequestMapping(path = "/getquestion", method = RequestMethod.POST)
	public String initForm(ForgotPasswordDTO forgotPasswordDTO, Map<String, Object> model) {

		Register entity = forgotPasswordService.checkUsername(forgotPasswordDTO);
		model.put("userDetails", entity);
		return "/answer.jsp";
	}

	@RequestMapping(path = "/getanswer", method = RequestMethod.POST)
	public String processAnswer(ForgotPasswordDTO forgotPasswordDTO, Model model) {

		boolean isValid = forgotPasswordService.checkAnswer(forgotPasswordDTO);
		if (isValid)
			return "/reset.jsp";
		else
			model.addAttribute("error", "Incorrect Answer...!!");
		return "/answer.jsp";

	}
	@RequestMapping(path="/update", method=RequestMethod.POST)
	public String resetPassword(ForgotPasswordDTO forgotPasswordDTO) {
		
	    forgotPasswordService.resetPassword(forgotPasswordDTO);
		return "redirect:/login.jsp";
	}
	  
}
