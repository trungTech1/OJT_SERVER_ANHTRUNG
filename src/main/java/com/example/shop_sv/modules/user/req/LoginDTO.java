package com.example.shop_sv.modules.user.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    @NotBlank(message = "Khong duoc de trong")

    private String username;
    @NotBlank(message = "Khong duoc de trong")
    private String password;
}
