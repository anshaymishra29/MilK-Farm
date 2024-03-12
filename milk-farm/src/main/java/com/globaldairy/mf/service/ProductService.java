package com.globaldairy.mf.service;

import java.util.List;

import com.globaldairy.mf.entity.Product;

public interface ProductService {

//	 Adding new products
	 Product addProduct(Product product);
	 
//	 Showing all products in dashboard
	 List<Product> showAllProduct(Product product);
	 
//	 Fetching products by product id
	 Product getProductById(Integer id);
	 
//	 Update product details by admin
	 Product updateProduct(Product product);
	 
//	 Delete product by admin
	 void deleteProductById(Integer id);
}
