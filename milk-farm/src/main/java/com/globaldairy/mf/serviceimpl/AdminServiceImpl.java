package com.globaldairy.mf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.globaldairy.mf.entity.Admin;
import com.globaldairy.mf.entity.Product;
import com.globaldairy.mf.repository.AdminRepository;
import com.globaldairy.mf.repository.ProductRepository;
import com.globaldairy.mf.service.AdminService;

@Service

public class AdminServiceImpl implements AdminService{

	private AdminRepository adminRepository;
	private ProductRepository productRepository;
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepository,ProductRepository productRepository) {
		super();
		this.adminRepository = adminRepository;
		this.productRepository = productRepository;
	}

	@Override
	public List<Admin> adminAuth() {
		
		return adminRepository.findAll();
	}


	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
	



	

}
