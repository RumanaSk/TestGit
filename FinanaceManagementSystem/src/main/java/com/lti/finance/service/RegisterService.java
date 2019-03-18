package com.lti.finance.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dao.RegisterDao;
import com.lti.finance.dto.RegisterDTO;
import com.lti.finance.entity.Register;

import java.text.ParseException;
@Service
public class RegisterService {
	// private static final String Calendar = null;
	@Autowired
	private RegisterDao registerDao;

	@Transactional
	public void register(RegisterDTO registerDTO) {
		Register register = new Register();
		register.setName(registerDTO.getName());

		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(registerDTO.getDob());
			register.setDob(date);
		}catch(ParseException e){ }
		register.setPhone(registerDTO.getPhone());
		register.setEmail(registerDTO.getEmail());
		register.setUsername(registerDTO.getUsername());
		register.setPassword(registerDTO.getPassword());
		register.setAddress(registerDTO.getAddress());
		register.setCardtype(registerDTO.getCardtype());
		register.setBank(registerDTO.getBank());
		register.setAccountno(registerDTO.getAccountno());
		register.setIfsccode(registerDTO.getIfsccode());
		register.setSecurityQuestion(registerDTO.getSecurityQuestion());
		register.setSecurityAnswer(registerDTO.getSecurityAnswer());
	
		register.setStatus(false);
		registerDao.add(register);
	}
}
