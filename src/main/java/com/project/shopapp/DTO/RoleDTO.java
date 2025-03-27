package com.project.shopapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoleDTO {
    @NotBlank(message = "Tên không được bỏ trống")
    @JsonProperty("name")
    private String name;
}
