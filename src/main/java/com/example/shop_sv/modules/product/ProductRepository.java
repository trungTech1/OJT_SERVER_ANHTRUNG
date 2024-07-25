package com.example.shop_sv.modules.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Byte> {
    Page<ProductModel> findByProductNameContainingIgnoreCase(String name, Pageable pageable);
    Page<ProductModel> findByStatus(Boolean status, Pageable pageable);
    Page<ProductModel> findByProductNameContainingIgnoreCaseAndStatus(String name, Boolean status, Pageable pageable);
}
