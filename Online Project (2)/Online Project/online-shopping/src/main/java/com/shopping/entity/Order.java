package com.shopping.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_order")
public class Order {

	@Id
	@GeneratedValue(generator = "pk_gen")
	@GenericGenerator(name = "pk_gen", strategy = "increment")
	private int id;
	
	private Date orderDate;
	private double amount;
    private String address;
    private String payment;
    
	@ManyToOne
	@JoinColumn(name = "loginId")
	private UserLoginCredentials userLoginCredentials;
	
	@OneToMany(mappedBy = "order")
	private Set<LineItem> lineItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public UserLoginCredentials getUserLoginCredentials() {
		return userLoginCredentials;
	}

	public void setUserLoginCredentials(UserLoginCredentials userLoginCredentials) {
		this.userLoginCredentials = userLoginCredentials;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	
}
