package com.project.shopapp.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
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
public class UserDTO {
    @NotBlank(message = "Số điện thoại không được bỏ trống")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "email không được bỏ trống")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Địa chỉ không được bỏ trống")
    @JsonProperty("address")
    private String address;

    @NotBlank(message = "Mật khẩu không được bỏ trống")
    @JsonProperty("password")
    private String password;

    @NotNull(message = "roleId không được bỏ trống")
    @JsonProperty("role_id")
    private long roleId;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("last_login_at")
    private LocalDateTime lastLoginAt;

    @NotNull(message = "facebookAccountId không được bỏ trống")
    @JsonProperty("facebook_account_id")
    private long facebookAccountId;

    @NotNull(message = "googleAccountId không được bỏ trống")
    @JsonProperty("google_account_id")
    private long googleAccountId;
}
