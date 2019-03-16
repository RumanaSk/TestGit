package com.lti.finance.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class GenericDao {// common dao for all classes here we will write the code which can be reused
	// sabkadao,sarvajanik dao, public dao

	public void merge(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-unit");
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			// em.persist(obj); can be used only for insert
			em.merge(obj);// merge method can be used for insert as well as update both
			tx.commit();
		} finally {

			em.close();
			emf.close();
		}

	}

	public <T> T fetch(Class<T> clazz, Object pk) { // will fetch any class primary key (id) return an obj of that class
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Persistence.createEntityManagerFactory("oracle-unit");
			em = emf.createEntityManager();
			T t = em.find(clazz, pk);
			return t;
		} finally {

			em.close();
			emf.close();
		}
	}

	public <T>List<T>  fetchAll(Class<T>clazz){
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			  emf = Persistence.createEntityManagerFactory("oracle-unit");
			  em = emf.createEntityManager();
	         String jpql = "select obj from "+clazz.getName()+" as obj";  //jpql is sql ,select all entries from class actor as alias a
	          return  em.createQuery(jpql,clazz).getResultList();
	} finally {

		em.close();
		emf.close();
	}
	   


	}

}
