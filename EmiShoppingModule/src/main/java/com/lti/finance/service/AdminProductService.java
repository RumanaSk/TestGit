package com.lti.finance.service;


	

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dao.AdminProductDao;
import com.lti.finance.dto.AdminProductDTO;
import com.lti.finance.entity.AdminProducts;
import com.lti.finance.entity.Product;

	@Service
	public class AdminProductService {
		@Autowired
		private AdminProductDao adminDao;

		public void addProducts(AdminProductDTO  adminDTO) {

			AdminProducts admin = new AdminProducts();
			admin.setCategoryname(adminDTO.getCategoryname());
			admin.setName(adminDTO.getName());
			admin.setPrice(adminDTO.getPrice());
			admin.setStocknumber(adminDTO.getStocknumber());
			admin.setPhoto(adminDTO.getPhoto());

			//ApplicationContext apx = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring-config2.xml");
			 
			//retailerDao = (RetailerDao) apx.getBean("retailerDao");
			 adminDao.add( admin);
		}


		public List<AdminProducts> getAllProducts() {
		
					List <AdminProducts> ProductList= adminDao.fetchAll();
					return ProductList;
		}
		
	

		public AdminProducts find(int id) {
			List <AdminProducts> ProductList= adminDao.fetchAll();
	
			for (AdminProducts admin : ProductList) {
				if (admin.getId()==(id)) {
					return admin;
				}
			}
			return null;
		}
	}
