package com.project.shopapp.Response;

import com.project.shopapp.Model.OrderDetail;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailResponse {
    private long id;
    private OrderResponse order;
    private ProductResponse product;
    private float price;
    private long numberOfProduct;
    private float totalMoney;
    private String colour;

    public static OrderDetailResponse fromOrderDetail(OrderDetail orderDetails) {
        return OrderDetailResponse.builder()
                .id(orderDetails.getId())
                .order(OrderResponse.fromOder(orderDetails.getOrder()))
                .product(ProductResponse.fromProduct(orderDetails.getProduct()))
                .price(orderDetails.getPrice())
                .numberOfProduct(orderDetails.getNumberOfProduct())
                .totalMoney(orderDetails.getTotalMoney())
                .colour(orderDetails.getColour())
                .build();
    }
}