package com.lti.finance.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.component.FinalException;
import com.lti.finance.entity.FinalUserEntity;

@Repository
public class FinalDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void add(FinalUserEntity fue) {
		entityManager.merge(fue);
	}
	public FinalUserEntity stat(int userId) throws FinalException  {
		Query query = entityManager.createQuery("select ue from FinalUserEntity as ue where ue.userId = :userId");
		query.setParameter("userId", userId);
		
		try{
			return (FinalUserEntity) query.getSingleResult();
		}catch (NoResultException e) {
			throw new FinalException("incorrect id");
					}	
	}
	
	public List<FinalUserEntity> fetch() {
		return entityManager.createQuery("select u from FinalUserEntity as u").getResultList();
	}

	public void updateStatus(int userId,boolean status) {
		FinalUserEntity f = entityManager.find(FinalUserEntity.class, userId);
		f.setStatus(status);
		entityManager.merge(f);
		//Query query = entityManager.createQuery("update FinalUserEntity as ue set ue.status = :status where ue.userId = :userId");
		//query.executeUpdate();
	}
}