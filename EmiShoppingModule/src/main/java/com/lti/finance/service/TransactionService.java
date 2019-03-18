package com.lti.finance.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.finance.dao.TransactionDao;
import com.lti.finance.entity.Item;
import com.lti.finance.entity.LineItem;
import com.lti.finance.entity.Order;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionDao transactionDao;
	
	
	@Transactional
	public Order placeOrder(List<Item> items) {
		
			Order order = new Order();
			
			order.setAmount(500);
			order.setOrderDate(new Date());
			order.setRegister(null);
			Order updatedOrder = (Order) transactionDao.add(order);
		
		
		
		for(Item item : items) {
			LineItem li = new LineItem();
			li.setOrder(updatedOrder);
			li.setAdminProducts(item.getAdminProducts());
			li.setQuantity(item.getQuantity());
			transactionDao.add(li);
		}
		
		return updatedOrder;
	}
	
	
}
