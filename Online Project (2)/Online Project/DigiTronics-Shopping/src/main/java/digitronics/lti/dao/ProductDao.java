package digitronics.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import digitronics.lti.entity.Product;

@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	public int add(Product product) {
		Product prod = entityManager.merge(product);
		return prod.getProd_id();
	}

	public Product fetch(int id) {
		return entityManager.find(Product.class, id);
	}

	public List<Product> fetchAll() {
		return entityManager.createQuery("select r from Product r").getResultList();
	}

	public List<Product> getProByNameId(String categoryName) {
		String jpql = "select p from Product p where p.categoryName = :category";
		return entityManager.createQuery(jpql).setParameter("category", categoryName).getResultList();
	}

	public List<Product> getProByPriceId(int toprice,int fromprice) {
		String jpql = "select p from Product p where p.price BETWEEN :start AND :end";
		return entityManager.createQuery(jpql).setParameter("start",toprice).setParameter("end", fromprice).getResultList();
	}


}
