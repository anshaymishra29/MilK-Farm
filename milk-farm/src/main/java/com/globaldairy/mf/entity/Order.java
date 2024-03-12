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
@Table(name = "order_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer_id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart_id;
	
	@Column(name = "order_quantity")
	private Integer order_quantity;
	
	@Column(name = "order_price")
	private Double  order_price;
	
	@Column(name = "customer_address")
	private String customer_address;

	public Order(Customer customer_id, Cart cart_id, Integer order_quantity, Double order_price,
			String customer_address) {
		super();
		this.customer_id = customer_id;
		this.cart_id = cart_id;
		this.order_quantity = order_quantity;
		this.order_price = order_price;
		this.customer_address = customer_address;
	}

	public Order(Integer order_id, Customer customer_id, Cart cart_id, Integer order_quantity, Double order_price,
			String customer_address) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.cart_id = cart_id;
		this.order_quantity = order_quantity;
		this.order_price = order_price;
		this.customer_address = customer_address;
	}

	public Order() {
		super();
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Customer customer_id) {
		this.customer_id = customer_id;
	}

	public Cart getCart_id() {
		return cart_id;
	}

	public void setCart_id(Cart cart_id) {
		this.cart_id = cart_id;
	}

	public Integer getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Integer order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", cart_id=" + cart_id
				+ ", order_quantity=" + order_quantity + ", order_price=" + order_price + ", customer_address="
				+ customer_address + "]";
	}
	
	
	
	
}
