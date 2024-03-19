package com.globaldairy.mf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globaldairy.mf.entity.Cart;
import com.globaldairy.mf.entity.Customer;
import com.globaldairy.mf.entity.Order;
import com.globaldairy.mf.entity.Product;
import com.globaldairy.mf.serviceimpl.AdminServiceImpl;
import com.globaldairy.mf.serviceimpl.CartServiceImpl;
import com.globaldairy.mf.serviceimpl.CustomerServiceImpl;
import com.globaldairy.mf.serviceimpl.OrderServiceImpl;
import com.globaldairy.mf.serviceimpl.ProductServiceImpl;

@Controller
public class CustomerController {

	private AdminServiceImpl adminServiceImpl;
	private ProductServiceImpl productServiceImpl;
	private CustomerServiceImpl customerServiceImpl;
	private CartServiceImpl cartServiceImpl;
	private OrderServiceImpl orderServiceImpl;
	
	@Autowired
    public CustomerController(AdminServiceImpl adminServiceImpl, ProductServiceImpl productServiceImpl,CustomerServiceImpl customerServiceImpl, CartServiceImpl cartServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
        this.productServiceImpl = productServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
        this.cartServiceImpl = cartServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }
	
//	Creating new user
	@PostMapping("/createuser")
	public String createUser(@ModelAttribute Customer customer) {
		
		customerServiceImpl.addNewCustomer(customer);
		return "customer_login";
	}
	
	
//	Customer login
	@PostMapping("/customerauth/dashboard")
	public String handleCustomerLogin(@ModelAttribute Customer customer,Model model, Product product) {
		
		List<Customer> data = customerServiceImpl.customerAuth(customer);
		
		for(Customer cstmr : data) {
			
			if(customer.getEmail().equals(cstmr.getEmail()) && customer.getPassword().equals(cstmr.getPassword())) {
				model.addAttribute("allproduct", productServiceImpl.showAllProduct(product));
				model.addAttribute("customer" , cstmr);
				model.addAttribute("success" , "Yor account has been created successfully, Kindly login to your account");
				return "dashboard";
			}
		}
		model.addAttribute("invalidcredential", "Invalid username or password");
		return "customer_login";
	}
	
	
	
//	Adding Item to cart(Customer)
	@PostMapping("addtocart/{product_id}/{customer_id}")
	public String addItemToCart(
	        @PathVariable("product_id") Integer product_id,
	        @PathVariable("customer_id") Integer customer_id,
	        @RequestParam("quantity") Integer quantity,
	        Model model) {

	    Customer c = customerServiceImpl.getCustomerById(customer_id);
	    Product p = productServiceImpl.getProductById(product_id);

	    System.out.println("Quantity: " + quantity + " Customer: " + c + " Product: " + p);

	    Cart cart = new Cart(c, p, quantity);
	    cartServiceImpl.addToCart(cart);
	    
	    model.addAttribute("customer" , c);
	    model.addAttribute("allproduct" , productServiceImpl.showAllProduct(p));
	    

	    return "dashboard";
	}
	
//	  Handling request for redirecting user for confirming order and enter address..(Customer)
	  @GetMapping("/buy/{cart_id}")
	  public String handleBuy(@PathVariable("cart_id") Integer cart_id, Model model) {
		  
		  Cart cart = cartServiceImpl.getCartItemById(cart_id);
		  Double totalPrice = cart.getQuantity() * cart.getProduct_id().getPrice();
		  model.addAttribute("cartitem",cart);
		  model.addAttribute("totalprice" , totalPrice);
		  
		  System.out.println("Total - "+totalPrice+""+cart);
		  
		  return "buy_now";
	  }
	  
	  
//	  Confirm order after entring address(Customer)
	  @GetMapping("/order/{cart_id}/{customer_id}/{totalprice}")
	  public String confirmOrder(@PathVariable("cart_id") Integer cart_id, 
			  @PathVariable("customer_id") Integer customer_id,
			  @PathVariable("totalprice") Double price, 
			  @RequestParam("customer_address") String customer_address,
			  Model model) {
		  
		  Cart cart = cartServiceImpl.getCartItemById(cart_id);
		  Customer customer = customerServiceImpl.getCustomerById(customer_id);
		  Integer quantity = cart.getQuantity();
		 
		  Order order = new Order(customer,cart,quantity,price,customer_address);
		  orderServiceImpl.confirmOrder(order);
//		  cartServiceImpl.removeItemFromCartByCartId(cart_id);
		  model.addAttribute("orders" , orderServiceImpl.getOrdersByCustomerIt(customer_id));
		  return "orders";
	  }
	  
	  
//    Fetching cart detaild of customer through customer id
	  @GetMapping("/cart/{customer_id}")
	  public String handleCart(@PathVariable Integer customer_id, Model model) {
		  
	  model.addAttribute("cartitem", cartServiceImpl.getCartDataByCustomerId(customer_id));
		  
		  List<Cart> list = cartServiceImpl.getCartDataByCustomerId(customer_id);
		  
		  for(Cart cart : list) {
			  System.out.println(cart);
		  }
		  
		  return "cart_view";
	  }
	  


	  
	  
//	  Handling request for deleting items from cart
	  @GetMapping("/removefromcart/{cart_id}/{customer_id}")
	  public String removeItemFromCart(@PathVariable("cart_id") Integer cart_id, @PathVariable("customer_id") Integer customer_id, Model model) {
		  cartServiceImpl.removeItemFromCartByCartId(cart_id);
		  model.addAttribute("cartitem", cartServiceImpl.getCartDataByCustomerId(customer_id));
         List<Cart> list = cartServiceImpl.getCartDataByCustomerId(customer_id);
		  
		  for(Cart cart : list) {
			  System.out.println(cart);
		  }
		  return "cart_view";
	  }
	  
//	  Showing data in orders page
	  @GetMapping("/orders/{customer_id}")
	  public String getOrdersByCustomerId(@PathVariable("customer_id") Integer customer_id, Model model) {
		 
		  model.addAttribute("orders" , orderServiceImpl.getOrdersByCustomerIt(customer_id));
		  
		  return "orders";
	  }
	  
//	  Delete order
	  @GetMapping("/cancelorder/{order_id}/{customer_id}")
	  public String cancelOrder(@PathVariable("order_id") Integer order_id, 
			  @PathVariable("customer_id") Integer customer_id,
			  Model model) {
		  System.out.println(order_id);
		  System.out.println(customer_id);
		  orderServiceImpl.deleteOrder(order_id);
		  model.addAttribute("orders" , orderServiceImpl.getOrdersByCustomerIt(customer_id));
		  return "orders";
	 
	  }
}
