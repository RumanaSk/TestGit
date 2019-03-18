package com.lti.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.finance.entity.FinalUserEntity;

@Repository
public class registerDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void add(FinalUserEntity ue) {
		entityManager.persist(ue);
	}

	public List<FinalUserEntity> fetchAll() {
		return entityManager.createQuery("select u from FinalUserEntity as u").getResultList();
	}
}
