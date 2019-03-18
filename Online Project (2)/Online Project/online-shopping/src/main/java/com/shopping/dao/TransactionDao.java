package com.shopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.entity.Product;
import com.shopping.entity.TransactionStatus;

@Repository
public class TransactionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Object  add(Object obj) {
		return entityManager.merge(obj);
	}


}
