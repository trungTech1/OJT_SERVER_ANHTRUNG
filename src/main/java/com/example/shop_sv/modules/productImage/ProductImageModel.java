package com.example.shop_sv.modules.productImage;

import com.example.shop_sv.modules.product.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="image")
@Entity
@Builder
public class ProductImageModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "image", length = 255)
    private String image = null;

    @Column(name = "status")
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "product")
    private ProductModel product = null;
}
