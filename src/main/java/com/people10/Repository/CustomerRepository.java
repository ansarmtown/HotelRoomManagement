package com.people10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.people10.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Customer findByEmail(String email);

}
