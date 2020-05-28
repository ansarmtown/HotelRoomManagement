package com.people10.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.people10.Repository.CustomerRepository;
import com.people10.annotation.UniqueEmail;

public class UniqEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	CustomerRepository custRepo;
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		
	}
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(custRepo ==null)
		{
			return true;
		}
		
		return custRepo.findByEmail(email)==null ;
	}

}
