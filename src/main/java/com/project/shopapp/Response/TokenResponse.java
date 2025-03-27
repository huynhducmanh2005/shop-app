package com.project.shopapp.Response;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class TokenResponse {
    private long id;
    private String token;
    private String tokenType;
    private LocalDateTime expirationDate;
    private boolean revoked;
    private boolean expired;
    private long userId;
}
