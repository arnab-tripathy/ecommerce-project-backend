package com.project.ecommerceapp.ecommerceapp.Repository;

import com.project.ecommerceapp.ecommerceapp.Entity.ShoppingCartItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<ShoppingCartItem,Long> {
    public List<ShoppingCartItem> findByCartId(Long id);

    @Query("select  s from ShoppingCartItem s where s.cartId= :cartId and s.productId= :productId")
    public ShoppingCartItem findByCartAndProductId(@Param("cartId") Long cartId, @Param("productId") Integer productId);


   @Modifying
   @Transactional
    @Query("delete from ShoppingCartItem c where c.productId= :productId and c.cartId= :cartId")
    public void removeFromCart(@Param("productId")int productId,@Param("cartId") Long cartId);
}