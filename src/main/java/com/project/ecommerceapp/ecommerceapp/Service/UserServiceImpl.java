package com.project.ecommerceapp.ecommerceapp.Service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Model.LoginRequest;
import com.project.ecommerceapp.ecommerceapp.Model.Status;
import com.project.ecommerceapp.ecommerceapp.Model.UserDto;
import com.project.ecommerceapp.ecommerceapp.Model.UserResponse;
import com.project.ecommerceapp.ecommerceapp.Model.UserSignupRequest;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	

	
	private static Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Override
	public UserResponse createnewUser(UserSignupRequest userRequest) {
		UserResponse userResponse=new UserResponse();
		try {
		String encodedPassword=bCryptPasswordEncoder.encode(userRequest.getPassword());
		System.out.println("encoded"+encodedPassword);
		//userRequest.setPassword(encodedPassword);
		User user =new User();
		//user.setId(1);
		user.setFirst_name(userRequest.getFirstName());
		user.setEmail(userRequest.getEmail());
		user.setLastt_name(userRequest.getLastName());
		user.setNumber(userRequest.getNumber());
		user.setPassword(encodedPassword);
		
		User savedUser=userRepo.save(user);
		Status status=new Status();
		if(savedUser!=null) {
		
		
		
		UserDto userDto=new UserDto();
		userDto.setEmail(savedUser.getEmail());
		userDto.setFirst_name(savedUser.getFirst_name());
		userDto.setLast_name(savedUser.getLastt_name());
		userDto.setMobile_number(savedUser.getNumber());
		userDto.setId(savedUser.getId());
		userResponse.setUser(userDto);
		userResponse.setStatusCode(HttpStatus.CREATED);
		}
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return userResponse ;
	}

	
	

}
