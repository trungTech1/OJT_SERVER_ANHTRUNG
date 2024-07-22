package com.example.shop_sv.modules.banner;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="banner")
@Entity
@Builder
public class BannerModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "banner_name", length = 255)
    private String bannerName = null;

    @Column(name = "image", length = 255)
    private String image = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "created_at", length = 255)
    private Date created_at = null;

    @Column(name = "description", length = 255)
    private String description = null;
}
