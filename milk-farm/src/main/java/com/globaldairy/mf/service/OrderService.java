package com.globaldairy.mf.service;

import java.util.List;

import com.globaldairy.mf.entity.Order;

public interface OrderService {

//	Confirm order for delivery
	void confirmOrder(Order order);
	
//	Fetching orders on the basis of customer id
	List<Order> getOrdersByCustomerIt(Integer customer_id);
}
