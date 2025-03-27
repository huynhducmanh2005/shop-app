package com.project.shopapp.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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

public class CategoryDTO {
    @NotBlank(message = "Tên không được bỏ trống")
    @JsonProperty("name")
    private String name;
}
