package com.lti.finance.entity;

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
    private int id;
	private int user_id;
	private int card_id;
	 @Column(name = "ac_type") 
	private String card_type;
	 
	private int min_limit;
	@OneToMany(mappedBy="account" , cascade=CascadeType.ALL)
	private Set<TransactionStatement> statements;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	
	
	
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMin_limit() {
		return min_limit;
	}
	public void setMin_limit(int min_limit) {
		this.min_limit = min_limit;
	}
	public Set<TransactionStatement> getStatements() {
		return statements;
	}
	public void setStatements(Set<TransactionStatement> statements) {
		this.statements = statements;
	}
	
}
