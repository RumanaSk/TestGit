package com.shopping.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.ProductDao;
import com.shopping.dto.ProductDto;
import com.shopping.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public void addProducts(ProductDto dto) {
		Product product = new Product();
		product.setCategoryname(dto.getCategoryname());
		product.setName(dto.getName());
		product.setPrice(dto.getPrice());
		product.setStocknumber(dto.getStocknumber());
		product.setPhoto(dto.getPhoto());
		productDao.add(product);
	}

	public List<Product> getAllProducts() {

		List<Product> ProductList = productDao.fetchAll();
		return ProductList;
	}

	public Product find(int id) {
		List<Product> ProductList = productDao.fetchAll();

		for (Product product : ProductList) {
			if (product.getId() == (id)) {
				return product;
			}
		}
		return null;
	}
}
