package com.project.shopapp.Response;

import java.time.LocalDateTime;

import com.project.shopapp.Model.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private long id;
    private String phoneNumber;
    private String email;
    private String address;
    // private String password;
    private RoleResponse role;
    private boolean isActive;
    private LocalDateTime lastLoginAt;
    private long facebookAccountId;
    private long googleAccountId;

    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .phoneNumber((user.getPhoneNumber()))
                .email(user.getEmail())
                .address(user.getAddress())
                // .password(user.getPassword())
                .role(RoleResponse.fromRole(user.getRole()))
                .isActive(user.isActive())
                .lastLoginAt(user.getLastLoginAt())
                .facebookAccountId(user.getFacebookAccountId())
                .googleAccountId(user.getGoogleAccountId())
                .build();
    }
}
