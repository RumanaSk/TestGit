package com.shopping.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_Status")
public class TransactionStatus {

	@Id
	@GeneratedValue
	private int transId;
	
	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	@OneToOne
	@JoinColumn(name="loginId")
    private UserLoginCredentials userLoginCredentails;
	
	@OneToOne
	@JoinColumn(name="id")
	private Product product;
	
	private boolean status;
	
	private String address;
	


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserLoginCredentials getUserLoginCredentails() {
		return userLoginCredentails;
	}

	public void setUserLoginCredentails(UserLoginCredentials userLoginCredentails) {
		this.userLoginCredentails = userLoginCredentails;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
