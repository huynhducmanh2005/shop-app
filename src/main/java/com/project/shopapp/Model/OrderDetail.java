package com.project.shopapp.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "order_details")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "price")
    private float price;

    @Column(name = "number_of_product")
    private long numberOfProduct;

    @Column(name = "total_money")
    private float totalMoney;

    @Column(name = "colour")
    private String colour;
}
