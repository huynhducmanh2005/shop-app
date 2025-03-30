package com.project.shopapp.Response;

import java.time.LocalDateTime;

import com.project.shopapp.Model.Token;
import com.project.shopapp.Model.User;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private long id;
    private String token;
    private String tokenType;
    private LocalDateTime expirationDate;
    private boolean revoked;
    private boolean expired;
    private UserResponse user;

    public static TokenResponse fromToken(Token token) {
        return TokenResponse.builder()
                .id(token.getId())
                .token(token.getToken())
                .tokenType(token.getTokenType())
                .expirationDate(token.getExpirationDate())
                .revoked(token.isRevoked())
                .expired(token.isExpired())
                .user(UserResponse.fromUser(token.getUser()))
                .build();

    }
}
