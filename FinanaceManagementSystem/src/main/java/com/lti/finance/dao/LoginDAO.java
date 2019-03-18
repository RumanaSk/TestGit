package com.lti.finance.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.finanace.component.LoginException;
import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;

@Repository
public class LoginDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public Register login(LoginDTO loginDTO) throws LoginException {

		Query query = entityManager.createQuery(	"select a from Register as a where a.username=:username and a.password=:password ");
		query.setParameter("username", loginDTO.getusername());
		query.setParameter("password", loginDTO.getpassword());
        try {
		return (Register) query.getSingleResult();
        }catch (NoResultException e) {
			throw new LoginException("incorrect username and password");
		}
	}
}



