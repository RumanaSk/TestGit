package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dto.adminDTO;
import com.lti.finance.entity.adminEntity;

@Repository
public class adminDao {
		@PersistenceContext
		
		private EntityManager entityManager;
		
		@Transactional
		public adminEntity fetchAdmin (adminDTO adminloginDTO) {
			Query query = entityManager.createQuery("select admin from adminEntity as admin where admin.username= :username and admin.password= :password");
			query.setParameter("username", adminloginDTO.getUsername());
			query.setParameter("password", adminloginDTO.getPassword());
			adminEntity ae = null;
			try{
			ae = (adminEntity) query.getSingleResult();}
			catch(NoResultException nre) {}
		if(ae == null) {
			System.out.println("invalid username and password");
		}
		return ae;
     }
}