package com.example.shop_sv.modules.ProductDetail;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    public ProductDetailModel save(ProductDetailModel productDetailModel) {
        return productDetailRepository.save(productDetailModel);
    }

    public List<ProductDetailModel> findAll() {
        return productDetailRepository.findAll();
    }
}
