package com.lti.finance.dao;
	import java.util.List;

import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;

	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.lti.finance.entity.Admin;

	@Repository
	public class AdminDao {

		@PersistenceContext
		private EntityManager entityManager;

		@Transactional
		public void add(Admin admin) {
			entityManager.persist(admin);
		}

		public List<Admin> fetchAll() {

				return entityManager.createQuery("select p from Admin p").getResultList();
			}
			
		
	}
