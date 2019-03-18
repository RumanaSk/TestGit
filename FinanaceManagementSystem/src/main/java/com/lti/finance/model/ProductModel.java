package com.lti.finance.model;



import java.util.ArrayList;
import java.util.List;
import com.lti.finance.entity.Product;

public class ProductModel {

	private List<Product> products;

	public ProductModel() {
		this.products = new ArrayList<Product>();
		this.products.add(new Product("p01", "Nikon Camera -D3300", "nikon-d3300.jpg", 200));
		this.products.add(new Product("p02", "Sony A-7", "sony-a7.jpg", 201));
		this.products.add(new Product("p03", "Canon S-8", "Canon 8.jpg", 202));
	}

	public List<Product> findAll() {
		return this.products;
	}

	public Product find(String id) {
		for (Product product : this.products) {
			if (product.getId().equalsIgnoreCase(id)) {
				return product;
			}
		}
		return null;
	}

}
