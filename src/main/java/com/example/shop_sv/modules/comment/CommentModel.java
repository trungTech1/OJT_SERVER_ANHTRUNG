package com.example.shop_sv.modules.comment;

import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.user.UserModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="comment")
@Entity
@Builder
public class CommentModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "comment", length = 255)
    private String comment = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "created_at")
    private Date created_at = null;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product = null;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user = null;


}
