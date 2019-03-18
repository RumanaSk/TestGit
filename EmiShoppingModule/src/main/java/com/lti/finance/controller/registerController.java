package com.lti.finance.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.finance.entity.FinalUserEntity;
import com.lti.finance.service.FinalService;
import com.lti.finance.service.registerService;

@Controller
public class registerController {

			@Autowired
			private registerService regservice;
			
			@RequestMapping(path="/list", method=RequestMethod.GET)
			public String list(Map<String, Object> model) {
				List<FinalUserEntity> list = regservice.getRegisteredusers();
				System.out.println("I am here");
				model.put("Users", list);
				return "/viewuser.jsp";
			}
}