package com.globaldairy.mf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globaldairy.mf.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

//	Custom query for fetching data from Cart table on the basis of customer id
	@Query("SELECT c FROM Cart c WHERE c.customer.id = :customer_id")
	List<Cart> getItemByCustomerId(@Param("customer_id") Integer customer_id);
}
