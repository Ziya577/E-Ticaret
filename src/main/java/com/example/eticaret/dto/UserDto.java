package com.example.eticaret.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "This field should not be empty")
    private String name;
    @NotNull(message = "This field should not be empty")
    private String surname;
    @NotNull(message = "This field should not be empty")
    private String phoneNumber;
    @Positive(message = "balance must be positive ")
    private BigDecimal balance;
    @Email(message = "This field must comply with Email standards")
    private String email;
}
