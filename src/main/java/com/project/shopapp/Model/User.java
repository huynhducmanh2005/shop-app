package com.project.shopapp.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private long roleId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "facebook_account_id")
    private long facebookAccountId;

    @Column(name = "google_account_id")
    private long googleAccountId;
}
