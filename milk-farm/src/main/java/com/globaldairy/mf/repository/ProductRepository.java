package com.globaldairy.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globaldairy.mf.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
