package com.lti.test;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.service.AccountService;

public class AccountStmtTest {

	/*@Test
       public void addAccount() {
		 AccountService s1 = new  AccountService();
	Account  ac= 	s1.openAccount("Rumana", "Saving",6000);
		GenericDao dao = new GenericDao();
		dao.merge(ac);
	}*/
	
	@Test
    public void addAccount() {
		 AccountService s1 = new  AccountService();
		s1.openAccount("Rumana", "Savings",15000);
	   s1.openAccount("Neha", "Savings", 70000);
}
	
@Test
public void withdraw() {
	AccountService s1 = new  AccountService();
	s1.withdraw(194,1000);
	s1.withdraw(195,10000);
 
}
@Test
public void deposit() {
	AccountService s1 = new  AccountService();
	s1.deposit(194,1000);
	s1.deposit(195,10000);
 
}


@Test
public void transfer() {
	AccountService s1 = new  AccountService();
	
	s1.transfer(195,194,50000);
 
}
@Test
public void check() {
	AccountService s1 = new  AccountService();
	s1.checkBalance(195);
	System.out.println();
}
}
