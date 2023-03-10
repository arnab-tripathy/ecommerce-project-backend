package com.project.ecommerceapp.ecommerceapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;

@Service
public interface ProductService {

	public List<Product> getAllProducts();
	
	public Page<Product> getProdductsById(int id,Pageable pageable);
	
	public Page<Product> findProductByName(String name, Pageable pageable);
	
	public Optional<Product> getProductDetails(int id);
}
