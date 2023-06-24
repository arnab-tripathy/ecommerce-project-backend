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

	@Autowired
	private AuthenticationManager manager;


	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/signup")
	public UserResponse signup(@RequestBody UserSignupRequest userRequest) {
		return userService.createnewUser(userRequest);
	}
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {

		boolean isEmailAuth=false;
		if(request.getUserEmail()!=null && !request.getUserEmail().isEmpty()){
			isEmailAuth=true;
		}

		if (isEmailAuth) {
			this.doAuthenticate(request.getUserEmail(), request.getPassword());
		} else {
			this.doAuthenticate(request.getPhoneNumber(), request.getPassword());
		}


		UserDetails userDetails = userDetailsService.loadUserByUsername(isEmailAuth?request.getUserEmail():request.getPhoneNumber());
		String token = this.helper.generateToken(userDetails);

		JwtResponse response = JwtResponse.builder()
				.jwtToken(token)
				.username(userDetails.getUsername()).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);


		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
