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
public class OrderDTO {
    @NotNull(message = "userId không được bỏ trống")
    @JsonProperty("user_id")
    private long userId;

    @NotBlank(message = "Họ và tên không được bỏ trống")
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "email không được bỏ trống")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Số điện thoại không được bỏ trống")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotBlank(message = "Ghi chú không được bỏ trống")
    @JsonProperty("notes")
    private String note;

    @JsonProperty("status")
    private String status;

    @NotBlank(message = "Địa chỉ không được bỏ trống")
    @JsonProperty("address")
    private String address;

    @JsonProperty("order_date")
    private LocalDateTime orderDate;
    @JsonProperty("total_money")
    private float totalMoney;
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @JsonProperty("shipping_date")
    private LocalDateTime shippingDate;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("is_active")
    private boolean isActive;
}
