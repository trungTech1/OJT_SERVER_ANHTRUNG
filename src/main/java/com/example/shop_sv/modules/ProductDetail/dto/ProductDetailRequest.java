package com.example.shop_sv.modules.ProductDetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailRequest {
    private String productDetailName;
    private Integer stock;
    private Double unitPrice;
    private Integer colorId;
    private Integer configId;
    private List<String> images;

}
