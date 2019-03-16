package com.lti.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ACNT")
public class Account {
	@Id // primary key
	@GeneratedValue // auto generate primary key
    private long acno;
	
	private String name;
	
	 @Column(name = "ac_type") 
	private String type;
	 
	private double balance;
	@OneToMany(mappedBy="account" , cascade=CascadeType.ALL)
	private Set<Statement> statements;
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Set<Statement> getStatements() {
		return statements;
	}
	public void setStatements(Set<Statement> statements) {
		this.statements = statements;
	}
	
}
