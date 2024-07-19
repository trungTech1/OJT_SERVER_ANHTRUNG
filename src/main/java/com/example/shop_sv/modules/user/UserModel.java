package com.example.shop_sv.modules.user;

import com.example.shop_sv.modules.role.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @Column(name = "username", length = 255)
    private String username = null;

    @Column(name = "password", length = 255)
    private String password = null;

    @Column(name = "email", length = 255)
    private String email = null;

    @Column(name = "phone", length = 255)
    private String phone = null;

    @Column(name = "full_name", length = 255)
    private String full_name = null;

    @Column(name = "avatar", length = 255)
    private String avatar = null;

    @Column(name = "point")
    private Double point = null;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "is_deleted")
    private Boolean is_deleted = null;

    @Column(name = "created_at")
    private Date created_at = null;

    @Column(name = "updated_at")
    private Date updated_at = null;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<UserRole> roles = new HashSet<>();

}
