package com.example.shop_sv.modules.product;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.brand.BrandModel;
import com.example.shop_sv.modules.category.CategoryModel;
import com.example.shop_sv.modules.productImage.ProductImageModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="product")
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductModel {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "product_name", length = 255)
    private String ProductName = null;

    @Column(name = "description", length = 255)
    private String description = null;

    @Column(name = "image", length = 255)
    private String image = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "created_at")
    private Date created_at = null;

    @Column(name = "sku", length = 255)
    private String sku = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BrandModel brand = null;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CategoryModel category = null;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductImageModel> images;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ProductDetailModel> productDetails;
}
