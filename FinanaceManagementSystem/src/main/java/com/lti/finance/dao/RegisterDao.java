package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.entity.Register;

@Repository
public class RegisterDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(Register register) {
		entityManager.merge(register);
	}
}
