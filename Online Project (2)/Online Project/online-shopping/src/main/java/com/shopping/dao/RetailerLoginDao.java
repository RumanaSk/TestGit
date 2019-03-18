
package com.shopping.dao;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.shopping.component.UserLoginException;
import com.shopping.dto.RetailerDto;
import com.shopping.entity.RetailerLoginCredentials;


@Repository
public class RetailerLoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(RetailerLoginCredentials retailerCredentials) {
		entityManager.persist(retailerCredentials);
	}

	public RetailerLoginCredentials login(RetailerDto dto) {
		Query query = entityManager.createQuery(
				"select retailer from RetailerLoginCredentials as retailer where retailer.username=:username and retailer.password=:password");
		query.setParameter("username", dto.getUsername());
		query.setParameter("password", dto.getPassword());

		try {
			return (RetailerLoginCredentials) query.getSingleResult();
		} catch (NoResultException nre) {
			throw new UserLoginException("Problem in user credentials");
		}
	}
}
