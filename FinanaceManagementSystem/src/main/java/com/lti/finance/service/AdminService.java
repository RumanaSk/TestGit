package com.lti.finance.service;


	

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dao.AdminDao;
import com.lti.finance.dto.AdminDTO;
import com.lti.finance.entity.Admin;
import com.lti.finance.entity.Product;

	@Service
	public class AdminService {
		@Autowired
		private AdminDao adminDao;

		public void addProducts(AdminDTO  adminDTO) {

			Admin admin = new Admin();
			admin.setCategoryname(adminDTO.getCategoryname());
			admin.setName(adminDTO.getName());
			admin.setPrice(adminDTO.getPrice());
			admin.setStocknumber(adminDTO.getStocknumber());
			admin.setPhoto(adminDTO.getPhoto());

			//ApplicationContext apx = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring-config2.xml");
			 
			//retailerDao = (RetailerDao) apx.getBean("retailerDao");
			 adminDao.add( admin);
		}


		public List<Admin> getAllProducts() {
		
					List <Admin> ProductList= adminDao.fetchAll();
					return ProductList;
		}
		
	

		public Admin find(int id) {
			List <Admin> ProductList= adminDao.fetchAll();
	
			for (Admin admin : ProductList) {
				if (admin.getId()==(id)) {
					return admin;
				}
			}
			return null;
		}
	}
