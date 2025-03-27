package com.project.shopapp.Response;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class OrderResponse {
    private long id;
    private long userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String note;
    private String status;
    private String address;
    private LocalDateTime orderDate;
    private float totalMoney;
    private String shippingMethod;
    private String shippingAddress;
    private LocalDateTime shippingDate;
    private String trackingNumber;
    private String paymentMethod;
    private boolean isActive;
}
