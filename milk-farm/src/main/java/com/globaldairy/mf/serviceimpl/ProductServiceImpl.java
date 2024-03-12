package com.globaldairy.mf.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldairy.mf.entity.Product;
import com.globaldairy.mf.repository.ProductRepository;
import com.globaldairy.mf.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> showAllProduct(Product product) {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		
		return productRepository.findById(id).get();	
	}

	@Override
	public Product updateProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		
		productRepository.deleteById(id);	
	}

	
}
