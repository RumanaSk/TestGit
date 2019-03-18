package com.shopping.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.dao.ProductDao;
import com.shopping.dao.TransactionDao;
import com.shopping.entity.Item;
import com.shopping.entity.LineItem;
import com.shopping.entity.Order;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionDao transactionDao;
	
	
	@Transactional
	public Order placeOrder(List<Item> items) {
		
			Order order = new Order();
			
			order.setAmount(500);
			order.setOrderDate(new Date());
			order.setUserLoginCredentials(null);
			Order updatedOrder = (Order) transactionDao.add(order);
		
		
		
		for(Item item : items) {
			LineItem li = new LineItem();
			li.setOrder(updatedOrder);
			li.setProduct(item.getProduct());
			li.setQuantity(item.getQuantity());
			transactionDao.add(li);
		}
		
		return updatedOrder;
	}
	
	
}
