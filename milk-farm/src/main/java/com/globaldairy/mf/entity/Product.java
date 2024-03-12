package com.globaldairy.mf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_tbl")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, columnDefinition = "INT")
	private Integer product_id;
	
	@Column(name = "product_name" , nullable = false)
	private String product_name;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "product_description", length=1000)
	private String product_description;

	public Product(String product_name, Double price, String product_description) {
		super();
		this.product_name = product_name;
		this.price = price;
		this.product_description = product_description;
	}

	public Product(Integer product_id, String product_name, Double price, String product_description) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.product_description = product_description;
	}

	public Product() {
		super();
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", product_description=" + product_description + "]";
	}

	
	
	
}
