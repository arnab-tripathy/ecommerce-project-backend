package com.project.ecommerceapp.ecommerceapp.Repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
	Page<Product> findByCategoryId(@Param("id") int id,Pageable pageable);
	
	
	//@Query(value="select * from product where product_name like '%Java%'",nativeQuery=true)
	Page<Product> findByProductNameContainingIgnoreCase(@Param("name")String name,Pageable pageable);

}
