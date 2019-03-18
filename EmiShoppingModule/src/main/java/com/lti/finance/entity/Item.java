package com.lti.finance.entity;


public class Item {

	private AdminProducts product;
	public AdminProducts getProduct() {
		return product;
	}

	public void setProduct(AdminProducts product) {
		this.product = product;
	}

	private int quantity;

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item() {
	}

	public Item(AdminProducts product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}
