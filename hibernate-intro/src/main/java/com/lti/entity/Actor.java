package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ACTOR")
public class Actor {
	@Id         //primary key
    @GeneratedValue  //auto generate primary key
    @Column(name = "ACTOR_ID")   //to give another name to column in database table other than the name given in class for column
	private int id;
	
	
	private String stageName;
	private String realName;
	private int noOfMovies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getNoOfMovies() {
		return noOfMovies;
	}

	public void setNoOfMovies(int noOfMovies) {
		this.noOfMovies = noOfMovies;
	}

}
