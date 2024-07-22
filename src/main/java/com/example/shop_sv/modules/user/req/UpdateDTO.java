package com.example.shop_sv.modules.user.req;



import com.example.shop_sv.modules.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateDTO {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private UserRole role;

    private String permission;

    private String avatar;

    private boolean status;

    private boolean is_deleted;

    private boolean isVerified;

    private String created_at;

    private String updated_at;

    private String newPassword;

}
