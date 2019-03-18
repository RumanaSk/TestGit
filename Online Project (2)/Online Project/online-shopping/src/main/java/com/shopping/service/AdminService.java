package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.AdminDao;
import com.shopping.dto.AdminDto;
import com.shopping.entity.AdminEntity;


@Service
public class AdminService {

@Autowired
private AdminDao adminDao;

public boolean login(AdminDto dto) {
	 AdminEntity ae = adminDao.fetchAdmin(dto);
	 if (ae != null) {
			return true;
		}			
	else 
			return false;
  }

}
