package com.project.shopapp.Response;

import java.time.LocalDateTime;

import org.aspectj.weaver.ast.Or;

import com.project.shopapp.Model.Order;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private long id;
    private UserResponse user;
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

    public static OrderResponse fromOder(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .user(UserResponse.fromUser(order.getUser()))
                .fullName(order.getFullName())
                .email(order.getEmail())
                .phoneNumber(order.getPhoneNumber())
                .note(order.getNote())
                .status(order.getStatus())
                .address(order.getAddress())
                .orderDate(order.getOrderDate())
                .totalMoney(order.getTotalMoney())
                .shippingMethod(order.getShippingMethod())
                .shippingDate(order.getShippingDate())
                .trackingNumber(order.getTrackingNumber())
                .paymentMethod(order.getPaymentMethod())
                .isActive(order.isActive())
                .build();
    }
}
