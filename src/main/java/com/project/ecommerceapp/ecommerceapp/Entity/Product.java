package com.project.ecommerceapp.ecommerceapp.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="sku")
	private String sku;
	@Column(name="product_name")
	private String productName;
	@Column(name="description")
	private String description;
	@Column(name="unit_price")
	private double unit_price;
	@Column(name="image_url")
	private String image_url;
	@Column(name="active")
	private boolean active;
	@Column(name="stock_units")
	private int stock_units;
	@Column(name="date_created")
	private Date dateCreated;
	@Column(name="last_updated")
	private Date lastUpdated;

//	
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	private ProductCategory category;
	
	
	
}
