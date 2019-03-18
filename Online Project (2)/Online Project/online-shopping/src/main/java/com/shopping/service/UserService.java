package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.component.UserLoginException;
import com.shopping.dao.UserLoginDao;
import com.shopping.dao.UserRegistrationDao;
import com.shopping.dto.UserDto;
import com.shopping.entity.UserLoginCredentials;
import com.shopping.entity.UserRegistrationDetails;

@Component
public class UserService {

	@Autowired
	private UserRegistrationDao registerDao;

	@Autowired
	private UserLoginDao loginDao;

	@Transactional
	public void add(UserDto dto) {

		UserRegistrationDetails registrationDetails = new UserRegistrationDetails();
		registrationDetails.setFullName(dto.getFullName());
		registrationDetails.setEmail(dto.getEmail());
		registrationDetails.setMobile(dto.getMobile());
		registrationDetails.setGender(dto.getGender());
		registrationDetails.setDateOfBirth(dto.getDateOfBirth());
		registerDao.add(registrationDetails);

		UserLoginCredentials loginCredentials = new UserLoginCredentials();
        loginCredentials.setRegistrationDetails(registrationDetails);;
		loginCredentials.setUserName(dto.getUserName());
		loginCredentials.setPassword(dto.getPassword());
		loginDao.add(loginCredentials);
	}

	public UserLoginCredentials login(UserDto dto) {
		try {
			UserLoginCredentials credentials = loginDao.login(dto);
			return credentials;
		} catch (UserLoginException nre) {
			return null;
		}

	}

}
