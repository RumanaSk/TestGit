package com.shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.component.UserLoginException;
import com.shopping.dto.AdminDto;
import com.shopping.entity.AdminEntity;

@Repository
public class AdminDao {
	
		@PersistenceContext
		private EntityManager entityManager;
		
		@Transactional
		public AdminEntity fetchAdmin(AdminDto dto)throws UserLoginException  {
			
			Query query = entityManager.createQuery("select credentials from AdminEntity as credentials where credentials.username = :username and credentials.password = :password");
			query.setParameter("username", dto.getUsername());
			query.setParameter("password", dto.getPassword());
			
			try {
				return (AdminEntity) query.getSingleResult();
			} catch (NoResultException e) {
				throw new UserLoginException("Please try again with valid username and password!");
			}
		}
}



		
		
		
		
		
		
		
		/*public AdminEntity fetchAdmin(AdminDto dto) {
			Query query = entityManager.createQuery("select a from Admin as a where a.username = :username and a.password = :password");
			query.setParameter("username", dto.getUsername());
			query.setParameter("password", dto.getPassword());
			
			AdminEntity ae = null;
			try{
			ae = (AdminEntity) query.getSingleResult();}
			catch(NoResultException nre) {}
		if(ae == null) {
			System.out.println("Invalid username and password");
		}
		return ae;
     }
}
*/