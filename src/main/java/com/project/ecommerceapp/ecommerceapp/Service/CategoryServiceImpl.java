package com.project.ecommerceapp.ecommerceapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.ProductCategory;
import com.project.ecommerceapp.ecommerceapp.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
CategoryRepository categoryRepository;

@Override
public List<ProductCategory> getAllCategory(){
	
	System.out.print("kk"+categoryRepository.findAll());
	return categoryRepository.findAll();
	
	
}
}
