package com.lti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

import com.lti.dao.ActorDao;

import com.lti.entity.Actor;

public class TestActor {

	@Test
	public void addHoRahaHaiYaNahiActor() {
		Actor actor = new Actor();
		actor.setStageName("SRK");
		actor.setRealName("ShahRukh Khan");
		actor.setNoOfMovies(9678);

		ActorDao dao = new ActorDao();
		dao.add(actor);
	}

@Test
public void fetch () {
	ActorDao dao = new ActorDao();
	Actor a = dao.fetch(1);
	//assertNotNull(a);
	
	// dont write sysout in actual TDD , use assert 
	System.out.println(a.getStageName());
	System.out.println(a.getRealName());
	System.out.println(a.getNoOfMovies());
}
	@Test
	public void  fetchAll(){
		ActorDao dao1 = new ActorDao();
		List<Actor> a1 = dao1.fetchAll();
		assertNotNull(a1);
       assertEquals(13, a1.size());	
 	
       for(Actor actor: a1) {
    	   System.out.println("====================");
    	   System.out.println(actor.getStageName());
    		System.out.println(actor.getRealName());
    		System.out.println(actor.getNoOfMovies());
       }
	}
       @Test
       public void fetchWhere(){
    	   ActorDao dao1 = new ActorDao();
   		List<Actor> a1 = dao1.fetchWhere(3000);
    	   assertNotNull(a1);
         	

           for(Actor actor: a1) {
        	   System.out.println("====================");
        	   System.out.println(actor.getStageName());
        		System.out.println(actor.getRealName());
        		System.out.println(actor.getNoOfMovies());
    	    
           }
	}
         /*  @Test
           public void  startsWith(){
        	   
        	   ActorDao dao1 = new ActorDao();
          		List<Actor> a1 = dao1.startsWith();
           	   assertNotNull(a1);
                	
           
        	   for(Actor actor: a1) {
            	   System.out.println("====================");
            	   System.out.println(actor.getStageName());
            		System.out.println(actor.getRealName());
            		System.out.println(actor.getNoOfMovies());
        	    
        	   }*/
       }
       }
       

