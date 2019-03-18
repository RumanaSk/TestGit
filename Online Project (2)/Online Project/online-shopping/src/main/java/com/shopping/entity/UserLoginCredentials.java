   package com.shopping.entity;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

		@Entity
		@Table(name = "User_Login_Credentials")
		
		public class UserLoginCredentials {
		
			@Id
			@GeneratedValue(generator= "inc")
			@GenericGenerator(name= "inc", strategy = "increment")
			private int loginId;
			private String userName;
			private String password;
			
			@OneToOne
			@JoinColumn(name="userId")
			private UserRegistrationDetails registrationDetails;
			
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
			public UserRegistrationDetails getRegistrationDetails() {
				return registrationDetails;
			}
			public void setRegistrationDetails(UserRegistrationDetails registrationDetails) {
				this.registrationDetails = registrationDetails;
			}
			

	}



