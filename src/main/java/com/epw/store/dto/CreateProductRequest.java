package com.epw.store.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    
    @NotBlank(message = "name is required")
    @Size(max = 150, message = "name must be <= 150")
    private String name;

    @Size(max = 2000, message = "description must be <= 2000")
    private String description;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price = BigDecimal.ZERO;

    @Min(0)
    private Integer stock = 0;

}
