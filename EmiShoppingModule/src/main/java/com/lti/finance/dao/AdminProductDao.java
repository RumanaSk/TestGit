package com.lti.finance.dao;
	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.lti.finance.entity.AdminProducts;

	@Repository
	public class AdminProductDao {

		@PersistenceContext
		private EntityManager entityManager;

		@Transactional
		public void add(AdminProducts admin) {
			entityManager.persist(admin);
		}

		public List<AdminProducts> fetchAll() {

				return entityManager.createQuery("select p from AdminProducts p").getResultList();
			}
			
		
	}
