package com.lti.service;

import java.util.Date;

import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Department;
import com.lti.entity.Statement;

//classes which contain business logic are commonly called as Service classes

public class AccountService {

	/*public Account openAccount(String name, String type, double initialBalance) {
		// 1 rec shld get inserted in account table
		// check min balance condition using if

		if (initialBalance == 5000.0) {
			Account ac = new Account();
			ac.setName(name);
			ac.setType(type);
			ac.setBalance(initialBalance);
			return ac;
		} else {
			return null;
		}*/
	
	
	public void addNewCard(String username, String type) {
		Account ac = new Account();
		ac.setName(username);
		ac.setType(type);
		if(type.equalsIgnoreCase("gold"))
		  ac.setBalance(60000);
		else
			ac.setBalance(160000);
		GenericDao dao = new GenericDao();
		dao.merge(ac);
	}
	public void withdraw(long acno, double amount) {
		// upadate the balance
		// on withdrawal statement shld record this action
		GenericDao dao = new GenericDao();
		Account ac = dao.fetch(Account.class, acno);
		Statement stmt = new Statement();
		if (amount <= ac.getBalance()) {
			ac.setBalance(ac.getBalance() - amount);
		stmt.setAccount(ac);
			stmt.setDate(new Date());

			stmt.setType("Withdraw");
			stmt.setAmount(amount);
		
			dao.merge(stmt);
			dao.merge(ac);
		}
		else System.out.println("not sufficient balance");
	}

	public void deposit(long acno, double amount) {
		// upadate the balance
		// on deposit statement shld record this action
		
		GenericDao dao = new GenericDao();
		Account ac = dao.fetch(Account.class, acno);
		Statement stmt = new Statement();
		if (amount !=0) {
			ac.setBalance(ac.getBalance() +amount);
		stmt.setAccount(ac);
			stmt.setDate(new Date());

			stmt.setType("Deposit");
			stmt.setAmount(amount);
		
			dao.merge(stmt);
			dao.merge(ac);
		}
		else System.out.println("please enter valid amount");
	}

	public void transfer(long fromacno, long toacno, double amount) {
		// add two account in account tbl
		// withdraw from one acc1
		// update balance acc1
		// deposit in other acc2
		// update blanceacc2
		// add both records in statement
		GenericDao dao = new GenericDao();
		Account ac = dao.fetch(Account.class, fromacno);
		Statement stmt = new Statement();
		if (amount <= ac.getBalance()) {
			ac.setBalance(ac.getBalance() - amount);
		stmt.setAccount(ac);
			stmt.setDate(new Date());

			stmt.setType("Withdraw");
			stmt.setAmount(amount);
		
			dao.merge(stmt);
			dao.merge(ac);
		}
		
		
		 ac = dao.fetch(Account.class, toacno);
		 stmt = new Statement();
		if (amount !=0) {
			ac.setBalance(ac.getBalance() +amount);
		stmt.setAccount(ac);
			stmt.setDate(new Date());

			stmt.setType("Deposit");
			stmt.setAmount(amount);
		
			dao.merge(stmt);
			dao.merge(ac);
		}
		else System.out.println("please enter valid amount");
		
		
		
	}

	public double checkBalance(long acno) {
		GenericDao dao = new GenericDao();
		
		Account ac = dao.fetch(Account.class, acno);
	System.out.println(" balance:" +ac.getBalance());

		
		return ac.getBalance();
	}

}
