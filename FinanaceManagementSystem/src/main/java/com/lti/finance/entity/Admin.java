package com.lti.finance.entity;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

	@Entity
	@Table(name = "tbl_admin_products")
	public class Admin {
		@Id
		@GeneratedValue(generator="pk_gen")
@GenericGenerator(name="pk_gen",strategy="increment")
		private int id;
		private String categoryname;
		private String name;
		private int stocknumber;
		private int price;
		private String photo;

	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCategoryname() {
			return categoryname;
		}

		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}

		

		public int getStocknumber() {
			return stocknumber;
		}

		public void setStocknumber(int stocknumber) {
			this.stocknumber = stocknumber;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		
	}
