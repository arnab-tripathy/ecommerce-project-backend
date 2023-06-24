package com.project.ecommerceapp.ecommerceapp.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	private String userEmail;
	private String phoneNumber;
	private String password;

}
