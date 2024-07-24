package com.example.shop_sv.modules.productImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductImageRepository extends JpaRepository<ProductImageModel, Byte> {
    @Modifying
    @Transactional
    @Query("DELETE FROM ProductImageModel p WHERE p.product.id = :productId")
    void deleteAllByProductId(Byte productId);
}
