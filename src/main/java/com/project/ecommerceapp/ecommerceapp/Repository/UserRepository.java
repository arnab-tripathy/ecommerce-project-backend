package com.project.ecommerceapp.ecommerceapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerceapp.ecommerceapp.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	
	public Optional<User> findByEmail(String email);

	public Optional<User> findByNumber(String number);

	@Query("select u from User u where u.email = :email or u.number= :number")
	public Optional<User> findByEmailOrNumbeer(@Param("email") String email,
											   @Param("number") String number);
	

}
