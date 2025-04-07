package com.project.shopapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "email không được bỏ trống")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Mật khẩu không được bỏ trống")
    @JsonProperty("password")
    private String password;

}
