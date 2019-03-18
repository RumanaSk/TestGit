package com.lti.finance.dto;
import org.springframework.web.multipart.MultipartFile;

	public class AdminDTO {

		private String categoryname;
		private String name;
		private int stocknumber;
		private int price;
		private String photo;
		
	

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

		public String getCategoryname() {
			return categoryname;
		}

		public void setCategoryname(String categoryname) {
			this.categoryname = categoryname;
		}

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

	}
