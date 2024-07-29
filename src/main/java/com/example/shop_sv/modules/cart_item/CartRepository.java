package com.example.shop_sv.modules.cart_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Byte> {
    @Query(value = "SELECT * FROM cart WHERE cart.user_id = :userId", nativeQuery = true)
    List<CartItem> findByUserId(Integer userId);
}
