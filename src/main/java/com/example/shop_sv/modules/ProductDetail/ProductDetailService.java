package com.example.shop_sv.modules.ProductDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
