package com.globaldairy.mf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_tbl")
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product_id;
    
    
//    @Column(name = "product_name", nullable = false)
//    private Product product_name;

    
	@Column(name = "quantity", nullable = false)
    private Integer quantity;


public Cart(Integer cart_id, Customer customer, Product product_id, Integer quantity) {
	super();
	this.cart_id = cart_id;
	this.customer = customer;
	this.product_id = product_id;
	this.quantity = quantity;
}


public Cart(Customer customer, Product product_id, Integer quantity) {
	super();
	this.customer = customer;
	this.product_id = product_id;
	this.quantity = quantity;
}


public Cart() {
	super();
}


public Integer getCart_id() {
	return cart_id;
}


public void setCart_id(Integer cart_id) {
	this.cart_id = cart_id;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}


public Product getProduct_id() {
	return product_id;
}


public void setProduct_id(Product product_id) {
	this.product_id = product_id;
}


public Integer getQuantity() {
	return quantity;
}


public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}


@Override
public String toString() {
	return "Cart [cart_id=" + cart_id + ", customer=" + customer + ", product_id=" + product_id + ", quantity="
			+ quantity + "]";
}


	

	
	
	
	
	

}
