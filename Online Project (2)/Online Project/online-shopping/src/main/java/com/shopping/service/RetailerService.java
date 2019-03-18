package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.component.UserLoginException;
import com.shopping.dao.RetailerLoginDao;
import com.shopping.dao.RetailerRegistrationDao;
import com.shopping.dto.RetailerDto;
import com.shopping.entity.RetailerLoginCredentials;
import com.shopping.entity.RetailerRegistrationDetails;

@Component
public class RetailerService {

	@Autowired
	private RetailerRegistrationDao retailerDao;

	@Autowired
	private RetailerLoginDao loginDao;

	@Transactional
	public void add(RetailerDto dto) {

		RetailerRegistrationDetails retailerDetails = new RetailerRegistrationDetails();
		retailerDetails.setFullname(dto.getFullname());
		retailerDetails.setDateOfBirth(dto.getDateOfBirth());
		retailerDetails.setGender(dto.getGender());
		retailerDetails.setMobile(dto.getMobile());
		retailerDetails.setEmail(dto.getEmail());
	    retailerDetails.setCategory(dto.getCategory());
		retailerDao.add(retailerDetails);

		RetailerLoginCredentials loginCredentials = new RetailerLoginCredentials();
		loginCredentials.setUsername(dto.getUsername());
		loginCredentials.setPassword(dto.getPassword());
		loginDao.add(loginCredentials);
	}

	public boolean login(RetailerDto dto) {
		try {
			RetailerLoginCredentials retailerCredentails = loginDao.login(dto);
			return true;
		} catch (UserLoginException nre) {
			return false;
		}

	}

}
