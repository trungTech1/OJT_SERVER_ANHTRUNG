package com.example.shop_sv.modules.config;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="config")
@Entity
@Builder
public class ConfigModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "config_name", length = 255)
    private String configName = null;

    @Column(name = "status", length = 255)
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetailModel productDetail;
}
