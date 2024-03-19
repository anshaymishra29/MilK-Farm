package com.globaldairy.mf.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globaldairy.mf.entity.Order;
import com.globaldairy.mf.repository.OrderRepository;
import com.globaldairy.mf.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private OrderRepository orderRepository; 
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}



	@Override
	public void confirmOrder(Order order) {
		orderRepository.save(order);
		
	}



	@Override
	public List<Order> getOrdersByCustomerIt(Integer customer_id) {
		
		return orderRepository.getOrderByCustomerId(customer_id);
	}



	@Override
	public void deleteOrder(Integer order_id) {
		
		 orderRepository.deleteById(order_id);
		 
	}

}
