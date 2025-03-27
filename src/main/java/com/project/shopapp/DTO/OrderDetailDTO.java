package com.project.shopapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderDetailDTO {
    @NotNull(message = "oderId không được bỏ trống")
    @JsonProperty("order_id")
    private long orderId;

    @NotNull(message = "productId không được bỏ trống")
    @JsonProperty("product_id")
    private long productId;

    @NotNull(message = "price không được bỏ trống")
    @JsonProperty("price")
    private float price;

    @NotNull(message = "numberOfProduct không được bỏ trống")
    @JsonProperty("number_of_product")
    private long numberOfProduct;

    @NotNull(message = "totalMoney không được bỏ trống")
    @JsonProperty("total_money")
    private float totalMoney;

    @NotNull(message = "color không được bỏ trống")
    @JsonProperty("colour")
    private String colour;
}
