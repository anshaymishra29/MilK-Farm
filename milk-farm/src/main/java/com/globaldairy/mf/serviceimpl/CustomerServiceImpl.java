package com.globaldairy.mf.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globaldairy.mf.entity.Customer;
import com.globaldairy.mf.repository.CustomerRepository;
import com.globaldairy.mf.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}



	@Override
	public Customer addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}



	@Override
	public List<Customer> customerAuth(Customer customer) {
		
		return customerRepository.findAll();
	}



	@Override
	public Customer getCustomerById(Integer id) {
		
		return customerRepository.findById(id).get();
	}

}
