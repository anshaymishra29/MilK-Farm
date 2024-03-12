package com.globaldairy.mf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin_tbl")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "admin_name" , nullable=false)
	private String adminName;
	
	@Column(name = "admin_email" , nullable = false, unique = true)
	private String adminEmail;
	
	@Column(name = "admin_password", nullable = false, length=10)
	private String adminPassword;

	public Admin(String adminName, String adminEmail, String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public Admin(Integer id, String adminName, String adminEmail, String adminPassword) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", adminPassword="
				+ adminPassword + "]";
	}
	
	
}
