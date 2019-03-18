package com.shopping.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "User_Login_Credentials")
public class User implements Serializable {
 
    private static final long serialVersionUID = -2054386655979281969L;
 
      
    private String userName;
    private String password;
    
    @Id
    @Column(name="userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

 
    
}
