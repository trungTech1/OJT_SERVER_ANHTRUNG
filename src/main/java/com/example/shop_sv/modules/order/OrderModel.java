package com.example.shop_sv.modules.order;

import com.example.shop_sv.modules.coupons.CouponsModel;
import com.example.shop_sv.modules.enums.OrderEnum;
import com.example.shop_sv.modules.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="orders")
@Entity
@Builder
public class OrderModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "created_at")
    private Date created_at = null;

    @Column(name = "status")
    private OrderEnum status = OrderEnum.SHIPPING;

    @Column(name = "total_price")
    private Double totalPrice = null;

    @Column(name = "district", length = 255)
    private String district = null;

    @Column(name = "note", length = 255)
    private String note = null;

    @Column(name = "phone", length = 255)
    private String phone = null;

    @Column(name = "province", length = 255)
    private String province = null;

    @Column(name = "receive_at")
    private Date receive_at = null;

    @Column(name = "receive_name", length = 255)
    private String receiveName = null;

    @Column(name = "serial_number", length = 255)
    private String serialNumber = null;

    @Column(name = "street_address", length = 255)
    private String streetAddress = null;

    @Column(name = "total_discounted_price", length = 255)
    private Double totalDiscountedPrice = null;

    @Column(name = "total_price_after_coupons", length = 255)
    private Double totalPriceAfterCoupons = null;

    @Column(name = "ward", length = 255)
    private String ward = null;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user = null;

    @ManyToOne
    @JoinColumn(name = "coupons_id")
    private CouponsModel coupons = null;
}
