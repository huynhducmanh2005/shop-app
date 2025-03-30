package com.project.shopapp.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank(message = "Số điện thoại không được bỏ trống")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "email không được bỏ trống")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "địa chỉ không được bỏ trống")
    @JsonProperty("address")
    private String address;

    @NotBlank(message = "Mật khẩu không được bỏ trống")
    @JsonProperty("password")
    private String password;

    @NotBlank(message = "Nhập lại mật khẩu không được bỏ trống")
    @JsonProperty("retypePassword")
    private String retypePassword;

    @JsonProperty("role_id")
    private long roleId = 1;

    @JsonProperty("is_active")
    private boolean isActive = true;

    @JsonProperty("last_login_at")
    private LocalDateTime lastLoginAt;

    @JsonProperty("facebook_account_id")
    private long facebookAccountId = 0;

    @JsonProperty("google_account_id")
    private long googleAccountId = 0;
}
