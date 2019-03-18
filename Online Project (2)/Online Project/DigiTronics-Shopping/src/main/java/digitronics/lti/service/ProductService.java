package digitronics.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digitronics.lti.dao.ProductDao;
import digitronics.lti.dto.ProductDTO;
import digitronics.lti.entity.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Transactional
	public int addProduct(ProductDTO productDTO) {
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setQuantity(productDTO.getQuantity());
		product.setPrice(productDTO.getPrice());
		product.setContent(productDTO.getContent());
		product.setProfilePicFileName(productDTO.getPro_images().getOriginalFilename());
		product.setCategoryName(productDTO.getCategoryName());
		
		return productDao.add(product);
	}

	public Product getAddedProduct(int id) {
		return productDao.fetch(id);
	}

	public List<Product> getAddedProduct() {
	
		return productDao.fetchAll();
	}

	public List<Product> getProductByName(String categoryName) {
		List<Product> products = productDao.getProByNameId(categoryName);
		return products;
	}

	public List<Product> getProductByPrice(int toprice, int fromprice) {
		List<Product> products = productDao.getProByPriceId(toprice,fromprice);
		return products;
	}

}
