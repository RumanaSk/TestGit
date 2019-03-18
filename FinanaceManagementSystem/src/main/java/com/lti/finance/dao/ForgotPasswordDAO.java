package com.lti.finance.dao;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import com.lti.finanace.component.LoginException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dto.ForgotPasswordDTO;
import com.lti.finance.dto.LoginDTO;
import com.lti.finance.entity.Register;

@Repository
public class ForgotPasswordDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public Register fetchQuestion(ForgotPasswordDTO forgotPasswordDTO) {

		Query query = entityManager.createQuery("select a from Register  a where a.username =:username");

		query.setParameter("username", forgotPasswordDTO.getUsername());
		return (Register) query.getSingleResult();
	}

	public Register validateAnswer(ForgotPasswordDTO forgotPasswordDTO) throws LoginException {

		Query query = entityManager.createQuery("select b from Register as b where b.securityAnswer = :securityAnswer");

		query.setParameter("securityAnswer", forgotPasswordDTO.getSecurityAnswer());
		try {
			return (Register) query.getSingleResult();
		} catch (NoResultException e) {
			throw new LoginException("Problem in answer selection");
		}
	}
	@Transactional
	public void updatePassword(ForgotPasswordDTO forgotPasswordDTO) {

		Query query = entityManager
				.createQuery("update Register as e set e.password=:password where e.username=:username");
		query.setParameter("username",forgotPasswordDTO.getUsername());
		query.setParameter("password", forgotPasswordDTO.getPassword());
		query.executeUpdate();
	}
}
