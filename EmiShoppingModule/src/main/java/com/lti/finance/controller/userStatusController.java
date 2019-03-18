package com.lti.finance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.finance.entity.FinalUserEntity;
import com.lti.finance.service.FinalService;
@SessionAttributes("userId")
@Controller
public class userStatusController {

	@Autowired
	private FinalService service;
	
	@RequestMapping(path="/singleuser", method=RequestMethod.GET)
	@Transactional
	public String fetchUserDetails(@RequestParam("userId") int userId, Map<String, Object>model) {
		FinalUserEntity id = service.stat(userId);
	if(id!= null) {
		model.put("UserStatus", id);
		return "/userform.jsp";
	}
	else 
		return "/userform.jsp";
	}
	
	@RequestMapping(path="/status", method=RequestMethod.GET)
	@Transactional
	public String status(@RequestParam("userId") int userId,@RequestParam("status") boolean status) {
//		FinalUserEntity js= service.stat(joinningmoney);
//		if(js!=null) {
		service.approveStatus(userId,status);
		System.out.println("i am here");
		return "/Status.jsp";
	}
	}
