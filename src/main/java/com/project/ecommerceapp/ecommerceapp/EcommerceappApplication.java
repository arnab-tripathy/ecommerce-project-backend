package com.project.ecommerceapp.ecommerceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;

@SpringBootApplication

@CrossOrigin(origins = "http://localhost:4200")
public class EcommerceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceappApplication.class, args);
		
		
		
	
	}

}
