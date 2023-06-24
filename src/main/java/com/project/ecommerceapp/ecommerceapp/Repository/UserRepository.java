package com.project.ecommerceapp.ecommerceapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerceapp.ecommerceapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	public User findByEmail(String email);
	
	public User findByEmailOrNumber(String email,String number);
}
