package com.project.ecommerceapp.ecommerceapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerceapp.ecommerceapp.Entity.ProductCategory;

public interface CategoryRepository  extends JpaRepository<ProductCategory, Integer>{
	

}
