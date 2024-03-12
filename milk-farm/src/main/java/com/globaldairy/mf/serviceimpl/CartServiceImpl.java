package com.globaldairy.mf.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globaldairy.mf.entity.Cart;
import com.globaldairy.mf.repository.CartRepository;
import com.globaldairy.mf.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	private CartRepository cartRepository;
	
	
	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}


	@Override
	public void addToCart(Cart cart) {
		cartRepository.save(cart);
		
	}


	@Override
	public List<Cart> getCartDataByCustomerId(Integer customer_id) {
		
		return cartRepository.getItemByCustomerId(customer_id);
	}


	@Override
	public Cart getCartItemById(Integer cart_id) {
		
		return cartRepository.findById(cart_id).get();
	}


	@Override
	public void removeItemFromCartByCartId(Integer id) {
		cartRepository.deleteById(id);
		
	}


	

	
}
