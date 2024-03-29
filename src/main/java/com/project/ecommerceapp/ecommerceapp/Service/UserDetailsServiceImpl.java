package com.project.ecommerceapp.ecommerceapp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.ecommerceapp.ecommerceapp.Entity.User;
import com.project.ecommerceapp.ecommerceapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=null;

		if(username.contains("@")){
			user=userRepo.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
		}else {
			 user = userRepo.findByNumber(username).orElseThrow(() -> new RuntimeException("user not found"));
		}
		return user;
	}

}
