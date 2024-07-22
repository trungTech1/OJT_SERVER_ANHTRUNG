package com.example.shop_sv.modules.coupons;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="coupons")
@Entity
@Builder
public class CouponsModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "code", length = 255)
    private String code = null;

    @Column(name = "discount", length = 255)
    private Integer discount = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "start_date", length = 255)
    private Date start_date = null;

    @Column(name = "end_date", length = 255)
    private Date end_date = null;

    @Column(name = "quantity")
    private Integer quantity = null;

    @Column(name = "title", length = 255)
    private String title = null;


}
