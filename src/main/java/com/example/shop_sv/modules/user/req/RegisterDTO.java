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
    @NotBlank(message = "Tài khoản không được để trống")
    @Size(min = 4, max = 20, message = "Tài khoản phải có từ 6 đến 20 ký tự")
    @UniqueField(fieldName = "userName", message = "Tài khoản đã tồn tại")

    String username;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 4, max = 20, message = "Mật khẩu phải có từ 4 đến 20 ký tự")
    String password;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @UniqueField(fieldName = "email", message = "Email đã tồn tại")
    String email;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 10, message = "Số điện thoại phải có 10 số")
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
