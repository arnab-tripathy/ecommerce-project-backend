package com.project.ecommerceapp.ecommerceapp.Repository;

import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCart;
import com.project.ecommerceapp.ecommerceapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<ShoppingCart,Long> {

    public ShoppingCart findByUserId(Long userId);

}
