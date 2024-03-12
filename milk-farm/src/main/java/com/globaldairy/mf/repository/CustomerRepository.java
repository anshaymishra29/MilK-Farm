package com.globaldairy.mf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globaldairy.mf.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer , Integer>{

}
