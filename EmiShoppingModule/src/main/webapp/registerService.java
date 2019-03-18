package com.lti.finance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dao.registerDao;
import com.lti.finance.dto.FinalDTO;
import com.lti.finance.dto.registerDTO;
import com.lti.finance.entity.FinalUserEntity;

@Service
public class registerService {

	@Autowired
	private registerDao rdao;
	
	@Transactional
	public void register(FinalDTO fdto) {
		FinalUserEntity fue = new FinalUserEntity();
		fue.setUserId(fdto.getUserId());
		fue.setName(fdto.getName());
		fue.setPhone(fdto.getPhone());
		fue.setEmail(fdto.getEmail());
		fue.setUsername(fdto.getUsername());
		fue.setStatus(false);
		fue.setPassword(fdto.getPassword());
		fue.setAddress(fdto.getAddress());
		fue.setCardtype(fdto.getCardtype());
		fue.setBank(fdto.getBank());
		fue.setAccountno(fdto.getAccountno());
		fue.setIfsccode(fdto.getIfsccode());
		rdao.add(fue);
	}
	
	public List<FinalUserEntity> getRegisteredusers() {
		return rdao.fetchAll();
	}
}
