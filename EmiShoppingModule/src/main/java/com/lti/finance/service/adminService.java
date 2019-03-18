package com.lti.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.finance.dao.adminDao;
import com.lti.finance.dto.adminDTO;
import com.lti.finance.entity.adminEntity;

@Service
public class adminService {

@Autowired
private adminDao adminDao;

public boolean login(adminDTO adminloginDTO) {
	 adminEntity adminDetails = adminDao.fetchAdmin(adminloginDTO);
	 if (adminDetails != null) {
			return true;
		}			
	else 
			return false;
  }

}
