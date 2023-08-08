package com.project.ecommerceapp.ecommerceapp.Service;



import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCart;
import com.project.ecommerceapp.ecommerceapp.Model.*;
import com.project.ecommerceapp.ecommerceapp.Repository.CartItemRepository;
import com.project.ecommerceapp.ecommerceapp.Repository.CartRepository;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	CartRepository cartRepo;

	@Autowired
	private  JwtHelper helper;

	@Autowired
	private AuthenticationManager manager;

	

	
	private static Logger logger=LoggerFactory.getLogger(UserService.class);
	
	@Override
	public UserResponse createnewUser(UserSignupRequest userRequest) {
		UserResponse userResponse=new UserResponse();
		try {
			if(userRepo.findByEmailOrNumbeer(userRequest.getEmail(), userRequest.getNumber()).isPresent()){
				userResponse.setFailureReason("Email or Number already present");
				return userResponse;
			}

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
		user.setRoles("USER");
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
		createShoppingCartForUser(savedUser);
			UserDetails userDetails=userDetailsService.loadUserByUsername(savedUser.getEmail());
			String token=this.helper.generateToken(userDetails);
			userResponse.setToken(token);

		}
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		// TODO Auto-generated method stub
		return userResponse ;
	}

	@Override
	public JwtResponse loginUser(LoginRequest request) {
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
		String userFirstName=getUserFirstName(userDetails.getUsername());
		JwtResponse response = JwtResponse.builder()
				.jwtToken(token)
				.userEmail(userDetails.getUsername())
				.userFirstName(userFirstName).build();

		logger.info((response.getJwtToken()+ response.getUserEmail()));
		return response;
	}
private String getUserFirstName(String userName){
		User user=userRepo.findByEmail(userName).get();
		return user.getFirst_name();
}
	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);


		} catch (Exception e) {
			logger.error("invalid credentials"+ e.getMessage());
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	private void createShoppingCartForUser(User savedUser) {
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setUser(savedUser);
		cartRepo.save(shoppingCart);

	}


}
