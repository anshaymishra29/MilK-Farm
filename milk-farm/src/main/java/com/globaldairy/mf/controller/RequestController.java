package com.globaldairy.mf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globaldairy.mf.entity.Admin;
import com.globaldairy.mf.entity.Cart;
import com.globaldairy.mf.entity.Customer;
import com.globaldairy.mf.entity.Order;
import com.globaldairy.mf.entity.Product;
import com.globaldairy.mf.service.AdminService;
import com.globaldairy.mf.serviceimpl.AdminServiceImpl;
import com.globaldairy.mf.serviceimpl.CartServiceImpl;
import com.globaldairy.mf.serviceimpl.CustomerServiceImpl;
import com.globaldairy.mf.serviceimpl.OrderServiceImpl;
import com.globaldairy.mf.serviceimpl.ProductServiceImpl;

@Controller
public class RequestController {
	
	@GetMapping("/")
	public String home() {
		
		return "index";
		
	}

//	To access admin login page
	@GetMapping("/index/admin")
	public String adminSignUp() {
		
		return "admin_login";
	}

	
//	Access customer signup page
	@GetMapping("/index/customersignup")
	public String customerSignupPage() {
		return "customer_signup";
	}
	
	
//	Accessing customer login page
	@GetMapping("/index/customerlogin")
	public String customerLoginPage() {
		return "customer_login";
	}
	

//	Handling about us page request
	@GetMapping("/aboutus")
	public String aboutUsPage() {
		return "about_us";
	}
	
//	Handling contact us page request
	@GetMapping("/contactus")
	public String contactUsPage() {
		return "contact_us";
	}
	
//	Handling contact us page request
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}

}