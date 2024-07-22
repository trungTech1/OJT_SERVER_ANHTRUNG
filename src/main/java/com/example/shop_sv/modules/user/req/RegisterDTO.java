package com.example.shop_sv.modules.user.req;

import com.example.shop_sv.validator.UniqueField;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDTO {
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 4, max = 20, message = "Do dai tu 6 den 20 ky tu")
    @UniqueField(fieldName = "userName", message = "Tài khoản đã tồn tại")

    String username;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 4, max = 20, message = "Do dai tu 6 den 20 ky tu")
    String password;
    @NotBlank(message = "Khong duoc de trong")
    @Email(message = "Email khong hop le")
    @UniqueField(fieldName = "email", message = "Email đã tồn tại")
    String email;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 10, max = 10, message = "Do dai 10 ky tu")
    @UniqueField(fieldName = "phone", message = "Số điện thoại đã tồn tại")
    String phone;


    @Override
    public String toString() {
        return "RegisterDTO{" +
                "userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +

                '}';
    }
}
