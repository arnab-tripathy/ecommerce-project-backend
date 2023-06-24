package com.project.ecommerceapp.ecommerceapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerceapp.ecommerceapp.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	
	public Optional<User> findByEmail(String email);

	public Optional<User> findByNumber(String number);
	

}
