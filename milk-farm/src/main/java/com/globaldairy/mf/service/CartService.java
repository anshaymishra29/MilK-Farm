package com.globaldairy.mf.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globaldairy.mf.entity.Cart;

public interface CartService {

//	Adding item to cart
	void addToCart(Cart cart);
	
//	Fetching cart data on the basis of customer id
    List<Cart> getCartDataByCustomerId(Integer customer_id);
    
//    Fetching cart data on the basis of cart id
    Cart getCartItemById(Integer cart_id);
    
//  Deleting cart data from cart table on the basis to cart id
    void removeItemFromCartByCartId(Integer id);
}
