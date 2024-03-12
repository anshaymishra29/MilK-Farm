package com.globaldairy.mf.service;

import java.util.List;

import com.globaldairy.mf.entity.Admin;
import com.globaldairy.mf.entity.Product;

public interface AdminService {

//	Admin authentication
	 List<Admin> adminAuth();

//	 Adding more products by admin
	 Product addProduct(Product product);
	
}
