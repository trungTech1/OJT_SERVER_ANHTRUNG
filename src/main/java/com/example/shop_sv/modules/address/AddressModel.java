package com.example.shop_sv.modules.address;
import com.example.shop_sv.modules.user.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="address")
@Entity
@Builder
public class AddressModel {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Byte id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserModel user = null;

    @Column(name = "district", length = 255)
    private String district = null;

    @Column(name = "phone", length = 255)
    private String phone = null;

    @Column(name = "priority", length = 255)
    private String priority = null;

    @Column(name = "province", length = 255)
    private String province = null;

    @Column(name = "ward", length = 255)
    private String ward = null;

    @Column(name = "receive_name", length = 255)
    private String receiveName = null;

    @Column(name = "street_address", length = 255)
    private String streetAddress = null;

}