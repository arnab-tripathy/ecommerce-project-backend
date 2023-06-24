package com.project.ecommerceapp.ecommerceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceapp.ecommerceapp.Model.LoginRequest;
import com.project.ecommerceapp.ecommerceapp.Model.UserResponse;
import com.project.ecommerceapp.ecommerceapp.Model.UserSignupRequest;
import com.project.ecommerceapp.ecommerceapp.Service.UserService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public UserResponse signup(@RequestBody UserSignupRequest userRequest) {
		return userService.createnewUser(userRequest);
	}
	

}
