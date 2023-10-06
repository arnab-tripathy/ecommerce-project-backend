package com.project.ecommerceapp.ecommerceapp.controller;

import com.project.ecommerceapp.ecommerceapp.Model.JwtResponse;
import com.project.ecommerceapp.ecommerceapp.security.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	private JwtHelper helper;




	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/signup")
	public UserResponse signup(@RequestBody UserSignupRequest userRequest) {
		logger.info("create user called");
		return userService.createnewUser(userRequest);
	}
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
		logger.info("login called"+request.toString());

	JwtResponse jwtResponse=userService.loginUser(request);
	return new ResponseEntity<>(jwtResponse,HttpStatus.OK);
	}



	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
