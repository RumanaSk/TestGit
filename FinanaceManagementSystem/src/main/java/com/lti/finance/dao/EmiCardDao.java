package com.lti.finance.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.finance.dto.EmiCard;
import com.lti.finance.entity.EmiCardEntity;
import com.lti.finance.entity.Register;

@Repository
public class EmiCardDao {

	@PersistenceContext
	private EntityManager em;

	public void add(EmiCardEntity emientity) {
		em.persist(emientity);
	}
	
	public EmiCardEntity fetchUserDetails( EmiCard emidto) {

		Query q =  em.createQuery("select  r from EmiCardEntity as r where r.username=:username");
		q.setParameter("username", emidto.getUsername());
		q.setParameter("cardtype", emidto.getType());
		EmiCardEntity e = (EmiCardEntity) q.getSingleResult();
		return e;

	}

//	public List<EmiCardEntity> fetchAll() {
//	return em.createQuery("select  r from EmiCardEntity as r").getResultList();
//	}

}
