package com.people10.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people10.customerHandler.RecordNotFoundException;
import com.people10.entity.Customer;
import com.people10.service.CustomerService;

@RestController
@RequestMapping("/api/")
public class PeopleController {
	
	@Autowired
	CustomerService custService;
	
	@GetMapping(value = "/customer")
	
	public List<Customer> getall()
	{
		
		return custService.getDetails();
	}
	@GetMapping("/customer/{id}")
	public Customer getOne(@PathVariable("id") long id)
	{
		if(custService.getcustomer(id) == null) {
	         throw new RecordNotFoundException("Invalid customer id : " + id);
	    }
		return custService.getcustomer(id) ;
	}
	
	@PostMapping(value = "/customer",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> insert(@Valid @RequestBody Customer customer ,BindingResult br)
	{
	
		if(br.hasErrors())
		{
		return new ResponseEntity(br.getAllErrors(),HttpStatus.BAD_REQUEST);
		}
		custService.save(customer);
		return new ResponseEntity<Customer>(HttpStatus.OK) ;
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> edit(@PathVariable long id,@RequestBody Customer c )
	{
		Customer cust =custService.getcustomer(id);
		if( cust== null) {
			 System.out.println("hai");
	         throw new RecordNotFoundException("Invalid customer id : " + id);
	    }
		custService.edit(c);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id)
	{
		if(custService.getcustomer(id) == null) {
	         throw new RecordNotFoundException("Invalid customer id : " + id);
	    }
		custService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
