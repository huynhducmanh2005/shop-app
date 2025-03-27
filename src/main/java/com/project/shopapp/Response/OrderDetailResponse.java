package com.project.shopapp.Response;

import jakarta.persistence.Column;

public class OrderDetailResponse {
    private long id;
    private long orderId;
    private long productId;
    private float price;
    private long numberOfProduct;
    private float totalMoney;
    private String colour;
}
