package com.example.shop_sv.modules.brand.dto.resquest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandReq {
    private String brandName;
    private String description;
    private String image;
}
