package com.example.shop_sv.modules.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="category")
@Entity
@Builder
public class CategoryModel {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name = "category_name", length = 255)
    private String name = null;
    @Column(name = "description", length = 255)
    private String description = null;
    @Column(name = "status")
    private Boolean status = true;
    @Column(name = "created_at")
    private Date created_at = null;
    @Column(name = "image", length = 255)
    private String image = null;
}
