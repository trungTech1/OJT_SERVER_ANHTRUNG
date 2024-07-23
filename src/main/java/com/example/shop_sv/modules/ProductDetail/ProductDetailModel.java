package com.example.shop_sv.modules.ProductDetail;

import com.example.shop_sv.modules.color.ColorModel;
import com.example.shop_sv.modules.config.ConfigModel;
import com.example.shop_sv.modules.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="product_detail")
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductDetailModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "image", length = 255)
    private String image = null;

    @Column(name = "product_detail_name", length = 255)
    private String productDetailName = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "stock")
    private Integer stock = 0;

    @Column(name = "unit_price")
    private Double unitPrice = 0.0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ColorModel color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductModel product = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "config_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ConfigModel config = null;
}
