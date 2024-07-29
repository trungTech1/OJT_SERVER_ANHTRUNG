package com.example.shop_sv.modules.wishlist;

import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishListModel, Byte> {
    Optional<WishListModel> findByUserAndProduct(UserModel user, ProductModel product);
}
