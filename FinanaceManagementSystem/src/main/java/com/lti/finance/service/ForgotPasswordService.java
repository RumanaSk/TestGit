package com.lti.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.finanace.component.LoginException;
import com.lti.finance.dao.ForgotPasswordDAO;
import com.lti.finance.dao.LoginDAO;
import com.lti.finance.dto.ForgotPasswordDTO;
import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;
@Component
public class ForgotPasswordService {
	@Autowired
	private ForgotPasswordDAO forgotPasswordDao;

	public Register checkUsername(ForgotPasswordDTO forgotPasswordDTO) {
		//return loginDAO.fetchQuestion(loginDTO);
		try {
		Register rusername=forgotPasswordDao.fetchQuestion(forgotPasswordDTO);
		return rusername;
	}catch(LoginException e) {
		return null;
	}
	}

	public boolean checkAnswer(ForgotPasswordDTO forgotPasswordDTO) {
		try {
			Register answer = forgotPasswordDao.validateAnswer(forgotPasswordDTO);
			return true;
		}catch (LoginException e) {
			return false;
		}
	}
		public  void resetPassword(ForgotPasswordDTO forgotPasswordDTO) {
			forgotPasswordDao.updatePassword(forgotPasswordDTO);
		}
		}
	

