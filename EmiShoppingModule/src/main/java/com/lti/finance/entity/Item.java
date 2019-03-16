package com.lti.finance.entity;


public class Item {

	private Admin product;
	public Admin getProduct() {
		return product;
	}

	public void setProduct(Admin product) {
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

	public Item(Admin product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}
