package com.lti.finance.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.component.FinalException;
import com.lti.finance.dao.FinalDao;
import com.lti.finance.dto.FinalDTO;
import com.lti.finance.entity.FinalUserEntity;

@Service
@Transactional
public class FinalService {
	// private static final String Calendar = null;
		@Autowired
		private FinalDao finalDao;
		
		public FinalUserEntity stat(int userId) throws FinalException {
			try {
				FinalUserEntity fue=finalDao.stat(userId);
				return fue;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
		public void register(FinalDTO finalDTO) {
			FinalUserEntity fue = new FinalUserEntity();
			
			fue.setUserId(finalDTO.getUserId());
			
			try {
				Date date=new SimpleDateFormat("yyyy-MM-dd").parse(finalDTO.getDob());
				fue.setDob(date);
			}catch (ParseException e) {}
			fue.setStatus(false);
			fue.setDocument_status(false);
			fue.setFee_status(false);
			fue.setSecurityanswer(finalDTO.getSecurityanswer());
			fue.setSecurityquestion(finalDTO.getSecurityquestion());
			fue.setName(finalDTO.getName());
			fue.setPhone(finalDTO.getPhone());
			fue.setEmail(finalDTO.getEmail());
			fue.setUsername(finalDTO.getUsername());
			fue.setPassword(finalDTO.getPassword());
			fue.setAddress(finalDTO.getAddress());
			fue.setCardtype(finalDTO.getCardtype());
			fue.setBank(finalDTO.getBank());
			fue.setAccountno(finalDTO.getAccountno());
			fue.setIfsc(finalDTO.getIfsc());

			finalDao.add(fue);
		}
		public List<FinalUserEntity> getRegistereduser() {
			return finalDao.fetch();
		}
		
		public void approveStatus(int userId,boolean status) {
		
			finalDao.updateStatus(userId,status);
		}
}