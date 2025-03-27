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
public class TokenDTO {
    @NotBlank(message = "Token không được bỏ trống")
    @JsonProperty("token")
    private String token;

    @NotBlank(message = "token_type không được bỏ trống")
    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expiration_date")
    private LocalDateTime expirationDate;

    @JsonProperty("revoked")
    private boolean revoked;

    @JsonProperty("expired")
    private boolean expired;

    @NotNull(message = "userId không được bỏ trống")
    @JsonProperty("user_id")
    private long userId;
}
