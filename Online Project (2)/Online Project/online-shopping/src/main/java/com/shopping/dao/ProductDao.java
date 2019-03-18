package com.shopping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.entity.Product;

@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(Product product) {
		entityManager.persist(product);
	}

	public List<Product> fetchAll() {

		return entityManager.createQuery("select p from Product p").getResultList();
	}

}
