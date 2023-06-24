package com.project.ecommerceapp.ecommerceapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerceapp.ecommerceapp.Entity.Product;
import com.project.ecommerceapp.ecommerceapp.Entity.ProductCategory;
import com.project.ecommerceapp.ecommerceapp.Service.CategoryService;
import com.project.ecommerceapp.ecommerceapp.Service.ProductService;

@RestController
@RequestMapping(path="/products")
@CrossOrigin(origins = "http://localhost:4200")
public class EcommerceController {

	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	
	
	
	@GetMapping(path="/getAllCategory")
	public ResponseEntity<List<ProductCategory>> getAllCategory(){
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		try {
			return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getProductByCategory")
	public ResponseEntity<Page<Product>> getProductByCategoryId(@RequestParam Integer id,@RequestParam int pageNum,@RequestParam int pageSize){
		Pageable pageable=PageRequest.of(pageNum, pageSize);
		System.out.println("id"+id);
		 return new ResponseEntity<>(productService.getProdductsById(id, pageable),HttpStatus.OK);
	}
	
	@GetMapping("/findProductByName")
	public ResponseEntity<Page<Product>> findProductByName(@RequestParam String name,@RequestParam int pageNum,@RequestParam int pageSize){
		Pageable pageable=PageRequest.of(pageNum,pageSize);
		System.out.print(name+" "+pageNum+" "+pageSize);
		return new ResponseEntity<>(productService.findProductByName(name, pageable),HttpStatus.OK);
	}
	
	@GetMapping("/getProductDetails")
	public ResponseEntity<Product> getProductDetails(@RequestParam Integer id) {
		 if (id == null || id <= 0) {
		        return ResponseEntity.badRequest().build();
		    }

		    try {
		        Optional<Product> product = productService.getProductDetails(id);
		        if (product.isPresent()) {
		            //log.info("Product with id {} found: {}", id, product.get().getImage_url());
		            return ResponseEntity.ok(product.get());
		        } else {
		           // log.info("Product with id {} not found", id);
		            return ResponseEntity.notFound().build();
		        }
		    } catch (Exception ex) {
		       // log.error("Error retrieving product with id " + id, ex);
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		    }
	}
}
