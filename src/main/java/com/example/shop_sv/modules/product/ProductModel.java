package com.example.shop_sv.modules.product;

import com.example.shop_sv.modules.brand.BrandModel;
import com.example.shop_sv.modules.category.CategoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="product")
@Entity
@Builder
public class ProductModel {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name = "product_name", length = 255)
    private String ProductName;
    @Column(name = "description", length = 255)
    private String description;
    @Column(name = "image", length = 255)
    private String image;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "created_at")
    private Date created_at;
    @Column(name = "sku", length = 255)
    private String sku;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandModel brand;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryModel category;


}
