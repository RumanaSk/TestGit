package com.lti.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finanace.component.LoginException;
import com.lti.finance.dao.EmiCardDao;
import com.lti.finance.dto.EmiCard;
import com.lti.finance.entity.EmiCardEntity;
import com.lti.finance.entity.Register;

@Service
public class EmiCardService {

	@Autowired
	private EmiCardDao emiDao;

	@Transactional
	public void emicard(EmiCard emidto) {

		EmiCardEntity emicard = new EmiCardEntity();
		emicard.setMin_limit(emidto.getMin_limit());
		emicard.setValid_upto(emidto.getValid_upto());
		emicard.setCvv(emidto.getCvv());

		emiDao.add(emicard);

	}

	public EmiCardEntity getUserDetails(EmiCard emidto, Register register) {
		try {
			register.getCardtype();
			EmiCardEntity card = emiDao.fetchUserDetails(emidto);
			return card;
		} catch (LoginException e) {
			return null;

		}
	}

}
