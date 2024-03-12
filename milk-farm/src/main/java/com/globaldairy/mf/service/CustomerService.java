package com.globaldairy.mf.service;

import java.util.List;

import com.globaldairy.mf.entity.Customer;

public interface CustomerService {

//	Creating new account of customer
	Customer addNewCustomer(Customer customer); 
	
//	Authenticating customer for login
	List<Customer> customerAuth(Customer customer);
	
//	Fetching customer by customer id
	Customer getCustomerById(Integer id);
}
