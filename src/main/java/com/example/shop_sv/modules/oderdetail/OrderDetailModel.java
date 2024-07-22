package com.example.shop_sv.modules.oderdetail;

import com.example.shop_sv.modules.ProductDetail.ProductDetailModel;
import com.example.shop_sv.modules.order.OrderModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="order_detail")
@Entity
@Builder
public class OrderDetailModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "order_quantity")
    private Integer oderQuantity = 0;

    @Column(name = "unit_price")
    private Double unitPrice = 0.0;

    @Column(name = "order_detail_name", length = 255)
    private String orderDetailName = null;

    @Column(name = "orders")
    private Byte orders = 0;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetailModel productDetail;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel oder;

}
