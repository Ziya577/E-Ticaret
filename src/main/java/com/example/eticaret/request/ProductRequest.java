package com.example.eticaret.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotNull(message = "This fiel can not be null")
    private Long id;
    @NotNull(message = "This field can not be null")
    private String name;
    @Positive(message = "Price must be a positive value.")
    private BigDecimal price;
    @Positive(message = "Price must be a positive value.")
    private Long amount;
    private String color;
    private String category;

}
