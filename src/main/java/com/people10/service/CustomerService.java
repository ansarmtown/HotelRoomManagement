package com.people10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.Repository.CustomerRepository;
import com.people10.entity.Customer;

@Service
public class CustomerService {
	@Autowired 
	CustomerRepository custRepo;
	
	public List<Customer> getDetails()
	{
		
		return custRepo.findAll();
	}
	
	public void save(Customer c)
	{
		custRepo.save(c);
	}
	
	public void edit(Customer c)
	{
		Customer cust =custRepo.findById(c.getId()).get();
		cust.setFirstName(c.getFirstName());
		cust.setLastName(c.getLastName());
		cust.setDob(c.getDob());
		cust.setEmail(c.getEmail());
		cust.setPassword(c.getPassword());
		custRepo.save(cust);
	}

	public Customer getcustomer(long id) {
		
		return custRepo.findById(id).get();
	}

	public void delete(long id) {
		
		custRepo.deleteById(id);
		
	}
	
	

}
