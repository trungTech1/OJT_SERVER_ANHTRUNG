package com.example.shop_sv.modules.cart_item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="cart")
@Entity
@Builder
public class CartItem {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Byte id;

    //producdetail_id
    @Column(name = "product_detail_id")
    private Byte productDetailId = null;

    //user_id
    @Column(name = "user_id")
    private Integer userId = null;

    @Column(name = "quantity")
    private Byte quantity = null;
}
