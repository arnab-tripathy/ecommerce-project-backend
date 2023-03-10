package com.project.ecommerceapp.ecommerceapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import com.project.ecommerceapp.ecommerceapp.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Page<Product> getProdductsById(int id,Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findByCategoryId(id, null);
	}

	@Override
	public Page<Product> findProductByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		System.out.print(name);
		//List<Product> prouctList=productRepository.findByNameContaining(name, pageable);
		return productRepository.findByNameContainingIgnoreCase(name,pageable);
	}

	@Override
	public Optional<Product> getProductDetails(int id) {
		// TODO Auto-generated method stub
		Optional<Product> product= productRepository.findById(id);
		return product;
	}

}
