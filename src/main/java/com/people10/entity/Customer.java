package com.people10.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GeneratorType;

import com.people10.annotation.UniqueEmail;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "fisrtName")
	@NotEmpty(message = "FirstName field not should be Null!")
	private String firstName;
	@NotEmpty(message = "LastName field not should be Null!")
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "date_of_birth")
	private Date dob;
	@NotEmpty(message = "Name field not should be Null!")
	@UniqueEmail(message="email already exist!")
	@Column(name = "email")
	private String email;
	@NotEmpty(message = "password filed not should be Null!")
	@Size(min = 6, max = 20 ,message = "minimum 6 charecter and maximum 20 charecter required!")
	@Column(name = "password")
	private String password;
	
	public Customer() {
		super();
	}
	
	public Customer(long id, String firstName, String lastName, Date dob, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + "]";
	}
	

	
	
	
	
}
