package com.project.ecommerceapp.ecommerceapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerceapp.ecommerceapp.Entity.ProductCategory;


@Repository
public interface CategoryRepository  extends JpaRepository<ProductCategory, Integer>{
	

}
