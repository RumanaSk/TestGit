package com.lti.finance.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.finanace.component.LoginException;
import com.lti.finance.dao.LoginDAO;
import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;

@Component
public class LoginService {
	
		@Autowired
		private LoginDAO loginDAO;

		public Register login(LoginDTO loginDTO) {
			try {
	    	Register loginDetails=loginDAO.login(loginDTO);
				return loginDetails ;
			
			}catch(LoginException e) {
			
				return null;
			}
			

		}

		

	}

	


