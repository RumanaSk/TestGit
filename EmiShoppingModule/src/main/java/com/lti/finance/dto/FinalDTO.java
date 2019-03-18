package com.lti.finance.dto;

import java.util.Date;

public class FinalDTO {
	
	
	public int userId;
	public double accountno;
	public String address;
	public String bank;
	public String cardtype;
	public String email;
	public String ifsc;
	public String name;
	public String password;
	public double phone;
	public boolean document_status;
	public boolean fee_status;
	public boolean status;
	public String username;
	public String securityanswer;
	public String securityquestion;
	private String dob;
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAccountno() {
		return accountno;
	}
	public void setAccountno(double accountno) {
		this.accountno = accountno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public boolean isDocument_status() {
		return document_status;
	}
	public void setDocument_status(boolean document_status) {
		this.document_status = document_status;
	}
	public boolean isFee_status() {
		return fee_status;
	}
	public void setFee_status(boolean fee_status) {
		this.fee_status = fee_status;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSecurityanswer() {
		return securityanswer;
	}
	public void setSecurityanswer(String securityanswer) {
		this.securityanswer = securityanswer;
	}
	public String getSecurityquestion() {
		return securityquestion;
	}
	public void setSecurityquestion(String securityquestion) {
		this.securityquestion = securityquestion;
	}
	
	
}
