package com.shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.entity.UserRegistrationDetails;

@Component
public class UserRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(UserRegistrationDetails registerDetails) {
		entityManager.persist(registerDetails);
		
	}

}
