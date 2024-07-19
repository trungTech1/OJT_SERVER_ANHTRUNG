package com.example.shop_sv.modules.brand;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="brand")
@Entity
@Builder
public class BrandModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name = "brand_name", length = 255)
    private String brandName = null;
    @Column(name= "description", length = 255)
    private String description = null;
    @Column(name= "image", length = 255)
    private String image = null;
    @Column(name= "status" )
    private Boolean status = true;
    @Column(name= "created_at")
    private Date created_at = null;
}
