package com.example.shop_sv.modules.wishlist;

import com.example.shop_sv.modules.product.ProductModel;
import com.example.shop_sv.modules.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="wishlist")
@Entity
@Builder
public class WishListModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "created_at")
    private String created_at = null;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product = null;

    @Column(name = "status")
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user = null;
}
