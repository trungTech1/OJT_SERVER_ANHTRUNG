package com.example.shop_sv.modules.user.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    @NotBlank(message = "Không được để trống")
    private String username;
    @NotBlank(message = "Không được để trống")
    private String password;
}
