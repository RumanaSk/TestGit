package com.lti.finance.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emi_card2")
public class EmiCardEntity {

	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	private int id;
	private int min_limit;
	private long card_id;
	@OneToOne
	@JoinColumn(name = "username")
	private Register username;
	private Date valid_upto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMin_limit() {
		return min_limit;
	}

	public void setMin_limit(int min_limit) {
		this.min_limit = min_limit;
	}

	public Date getValid_upto() {
		return valid_upto;
	}

	public void setValid_upto(Date valid_upto) {
		this.valid_upto = valid_upto;
	}

	public long getCard_id() {
		return card_id;
	}

	public void setCard_id(long card_id) {
		this.card_id = card_id;
	}

	public Register getUsername() {
		return username;
	}

	public void setUsername(Register username) {
		this.username = username;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	private int cvv;

}
