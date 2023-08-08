package com.project.ecommerceapp.ecommerceapp.Model;

import jakarta.persistence.Column;

public class ProductDTO {

    private int id;
    private String sku;
    private String name;
    private String description;
    private double unit_price;
    private String image_url;
    private boolean active;
    private int stock_units;
}
