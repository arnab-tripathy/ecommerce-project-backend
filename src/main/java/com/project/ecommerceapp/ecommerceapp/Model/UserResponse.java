package com.project.ecommerceapp.ecommerceapp.Model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponse {
	
	private HttpStatus StatusCode;
	private UserDto user;
	private String token;
	private String failureReason;

}
