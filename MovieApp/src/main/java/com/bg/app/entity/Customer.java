/*package com.bg.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	//store id 
	//address id 
	
	@Column(name="first_name")
	@Size(max=45)
	@NotNull
	private String firstName;

	@Column(name="last_name")
	@Size(max=45)
	@NotNull
	private String lastName;
	
	@Column(name="email")
	@Size(max=50)
	private String email;
	
	@Column(name="active")
	@NotNull
	private Integer active;
	
	
	
}
*/