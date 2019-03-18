package com.shopping.entity;

public class Item {

	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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

	public Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

}
