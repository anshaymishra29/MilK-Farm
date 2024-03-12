package com.globaldairy.mf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.globaldairy.mf.entity.Admin;
import com.globaldairy.mf.entity.Product;
import com.globaldairy.mf.serviceimpl.AdminServiceImpl;
import com.globaldairy.mf.serviceimpl.CartServiceImpl;
import com.globaldairy.mf.serviceimpl.CustomerServiceImpl;
import com.globaldairy.mf.serviceimpl.OrderServiceImpl;
import com.globaldairy.mf.serviceimpl.ProductServiceImpl;

@Controller
public class AdminController {

	private AdminServiceImpl adminServiceImpl;
	private ProductServiceImpl productServiceImpl;
	private CustomerServiceImpl customerServiceImpl;
	private CartServiceImpl cartServiceImpl;
	private OrderServiceImpl orderServiceImpl;
	
	@Autowired
    public AdminController(AdminServiceImpl adminServiceImpl, ProductServiceImpl productServiceImpl,CustomerServiceImpl customerServiceImpl, CartServiceImpl cartServiceImpl, OrderServiceImpl orderServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
        this.productServiceImpl = productServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
        this.cartServiceImpl = cartServiceImpl;
        this.orderServiceImpl = orderServiceImpl;
    }

//	Admin Authentication
	@PostMapping("/adminauth")
	public String adminAuthentication(@ModelAttribute Admin admin, Model model) {
		
		List<Admin> ad = adminServiceImpl.adminAuth();
		System.out.println(admin);
		
		for(Admin admn : ad) {
			
			if(admin.getAdminEmail().equals(admn.getAdminEmail()) &&
					admin.getAdminPassword().equals(admn.getAdminPassword())) {
				
				return "admin_access";
			
			}
		}
		
		
		
		model.addAttribute("invalidcredential", "Invalid username or password");
		return "admin_login";
	}
	
	
//	For handling request to add product in product table(Admin access only) 
	@PostMapping("/additem")
	public String addItem(@ModelAttribute Product product, Model model) {
		
		
		adminServiceImpl.addProduct(product);
		model.addAttribute("allproduct" , productServiceImpl.showAllProduct(product));
		
		return "admin_access";
	}
	
//	View product list(Admin)
	@GetMapping("/viewproduct")
	public String viewProductListInAdminPanel(Product product, Model model) {
		model.addAttribute("allproduct" , productServiceImpl.showAllProduct(product));
		
		return "admin_access";
	}
	
//	For handling request to fect data of single user for editing or update(Admin)
	@GetMapping("/product/edit/{product_id}")
	public String getProductByPRoductId(@PathVariable Integer product_id, Model model) {
		model.addAttribute("product", productServiceImpl.getProductById(product_id));
		return "edit_product";
	}
	
//	Update product(Admin)
	@PostMapping("/product/{product_id}")
	public String updateProduct(@ModelAttribute Product product, @PathVariable Integer product_id, Model model) {
		
		Product existingProduct = productServiceImpl.getProductById(product_id);
		existingProduct.setProduct_id(product_id);
		existingProduct.setProduct_name(product.getProduct_name());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setProduct_description(product.getProduct_description());
		
		//save update product object
		productServiceImpl.updateProduct(existingProduct);
		return "admin_access";
	}
	
//	Delete product By product id
	@GetMapping("/product/delete/{product_id}")
	public String deleteProduct(@PathVariable Integer product_id) {
		productServiceImpl.deleteProductById(product_id);
		return "admin_access";
	}
	
}
