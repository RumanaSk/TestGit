package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Actor;

public class ActorDao {
	public void add(Actor actor) {
		// Step 1. Create Obtain EntityManagerFactory object
		// During this step,META-INF /persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");

		// Step2.Create/Obtain EntityManager object
		// During this step, a connection will be opened to the database
		EntityManager em = emf.createEntityManager();

		// Step3. StartParticipate in a transaction
		// Hibernate doesn't auto commits,we need to take care of it
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// Now we can insert/update/delete/select,whatever we want
		em.persist(actor);// persist method will generate insert query for us

		tx.commit();

		// below code should be in finally block
		em.close();
		emf.close();

	}

	public Actor fetch(int actorId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
		EntityManager em = emf.createEntityManager();
		Actor a = em.find(Actor.class, actorId);// find method generates select query
		em.close();
		emf.close();
		return a;
	}
public List<Actor> fetchAll(){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
	EntityManager em = emf.createEntityManager();
    String jpql = "select a from Actor as a";  //jpql is sql ,select all entries from class actor as alias a
	Query q = em.createQuery(jpql);
	List<Actor> actors = q.getResultList();
    em.close();
	emf.close();
return actors;
}


public List<Actor> fetchWhere(int  noOfMovies){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
	EntityManager em = emf.createEntityManager();
    String jpql = "select a from Actor as a where a. noOfMovies >= :no";  //jpql is sql ,select all entries from class actor as alias a
	Query q = em.createQuery(jpql);
	q.setParameter("no",  noOfMovies);
	List<Actor> actors = q.getResultList();
    em.close();
	emf.close();
return actors;
}
/*
 * error in code refer someone else prg
 * public List<Actor> startsWith(){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-unit");
	EntityManager em = emf.createEntityManager();
   //jpql is sql ,select all entries from class actor as alias a
   String jpql = "select a from Actor as a where a.realName LIKE :r% ";
	//String jpql="select a from Actor   as a where a.realNameLIKE :parent%";
	
	Query q = em.createQuery(jpql);

	List<Actor> actors = q.getResultList();
    em.close();
	emf.close();
return actors;


}
*/
}