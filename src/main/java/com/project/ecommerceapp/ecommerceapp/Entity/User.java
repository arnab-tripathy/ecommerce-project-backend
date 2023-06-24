package com.project.ecommerceapp.ecommerceapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="app_user")
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String lastt_name;
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String number;
	@Column(name="userpass")
	private String password;
	
	@Column(name="roles")
	private String roles;
	
}
