package com.project.ecommerceapp.ecommerceapp.Service;

import com.project.ecommerceapp.ecommerceapp.Model.JwtResponse;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Model.LoginRequest;
import com.project.ecommerceapp.ecommerceapp.Model.UserResponse;
import com.project.ecommerceapp.ecommerceapp.Model.UserSignupRequest;

@Service
public interface UserService {
public UserResponse createnewUser(UserSignupRequest userRequest);

public JwtResponse loginUser(LoginRequest loginRequest);

}
