package com.example.shop_sv.modules.productImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImageModel> saveAll(List<ProductImageModel> productImageModels) {
        return productImageRepository.saveAll(productImageModels);
    }

    public void deleteAllByProductId(Byte productId) {
        productImageRepository.deleteAllByProductId(productId);
    }

}