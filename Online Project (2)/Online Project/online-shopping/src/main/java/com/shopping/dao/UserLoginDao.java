package com.shopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.component.UserLoginException;
import com.shopping.dto.UserDto;
import com.shopping.entity.UserLoginCredentials;

@Repository
public class UserLoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void add(UserLoginCredentials loginCredentials) {
		entityManager.persist(loginCredentials);
	}

	public UserLoginCredentials login(UserDto dto) {
		Query query = entityManager.createQuery("select user from UserLoginCredentials as user where user.userName=:userName and user.password=:password");
		query.setParameter("userName", dto.getUserName());
		query.setParameter("password", dto.getPassword());

		try {
			return (UserLoginCredentials) query.getSingleResult();
		} catch (NoResultException nre) {
			throw new UserLoginException("Problem in user credentials");
		}
	}
}
