package com.project.ecommerceapp.ecommerceapp.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_category")
@Getter
@Setter
public class ProductCategory {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="category_name")
	private String category_name;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	private Set<Product> products;
	
	
	

}
