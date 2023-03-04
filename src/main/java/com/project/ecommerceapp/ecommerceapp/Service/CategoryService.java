package com.project.ecommerceapp.ecommerceapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.ecommerceapp.ecommerceapp.Entity.ProductCategory;
@Service
public interface CategoryService {
	public List<ProductCategory> getAllCategory();

}
