package com.globaldairy.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globaldairy.mf.entity.Cart;
import com.globaldairy.mf.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//	Custom query for fetching data from Order table on the basis of customer id 
	@Query("SELECT o FROM Order o WHERE o.customer_id.customer_id = :customer_id")
	List<Order> getOrderByCustomerId(@Param("customer_id") Integer customer_id);
}
