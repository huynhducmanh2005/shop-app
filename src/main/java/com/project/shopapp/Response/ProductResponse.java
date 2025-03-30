package com.project.shopapp.Response;

import com.project.shopapp.Model.Product;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private long id;
    private String name;
    private float price;
    private String thumbnail;
    private CategoryResponse category;
    private String description;

    public static ProductResponse fromProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .thumbnail(product.getThumbnail())
                .category(CategoryResponse.fromCategory(product.getCategory()))
                .description(product.getDescription())
                .build();
    }
}
