package com.example.shop_sv.modules.product.dto.request;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.ProductDetail.dto.ProductDetailRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateDTO {

    private String productName ;

    private String description;

    private List<String> images;

    private String sku ;

    private Integer brandId;

    private Integer categoryId;

}
