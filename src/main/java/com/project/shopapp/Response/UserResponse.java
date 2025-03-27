package com.project.shopapp.Response;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class UserResponse {
    private long id;
    private String phoneNumber;
    private String email;
    private String address;
    private String password;
    private long roleId;
    private boolean isActive;
    private LocalDateTime lastLoginAt;
    private long facebookAccountId;
    private long googleAccountId;
}
