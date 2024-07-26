package com.example.shop_sv.modules.user.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordDTO {
    private Integer id;
    private String oldPassword;
    private String newPassword;
}
