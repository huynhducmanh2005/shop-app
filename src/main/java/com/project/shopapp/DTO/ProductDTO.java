package com.project.shopapp.DTO;

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
public class ProductDTO {

    @NotBlank(message = "Tên sản phẩm không được bỏ trống")
    @JsonProperty("name")
    private String name;

    @NotNull(message = "Giá không được bỏ trống")
    @JsonProperty("price")
    private float price;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @NotNull(message = "Mã loại hàng không được bỏ trống")
    @JsonProperty("category_id")
    private long categoryId;

    @NotBlank(message = "Mô tả không được bỏ trống")
    @JsonProperty("description")
    private String description;
}
