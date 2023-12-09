package com.example.eticaret.dto;

import com.example.eticaret.model.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @NotEmpty(message = "Name filed can not be empty ")
    private String name;
    @Positive(message = "Balance must be positive")
    private BigDecimal price;
    @Positive(message = "Amount must be positive")
    private Long amount;
    @NotNull(message = "This field must not be empty")
    private String color;
    @NotNull(message = "This field must not be empty")
    private String category;

}
