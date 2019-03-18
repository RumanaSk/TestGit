package com.shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.entity.RetailerRegistrationDetails;

@Component
public class RetailerRegistrationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(RetailerRegistrationDetails retailerDetails) {
		entityManager.persist(retailerDetails);
		
	}

}

