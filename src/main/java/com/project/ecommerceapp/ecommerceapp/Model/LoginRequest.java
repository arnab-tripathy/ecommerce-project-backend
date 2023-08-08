package com.project.ecommerceapp.ecommerceapp.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequest {
	
	private String userEmail;
	private String phoneNumber;
	private String password;

}
