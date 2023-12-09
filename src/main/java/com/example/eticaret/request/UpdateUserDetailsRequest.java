package com.example.eticaret.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDetailsRequest {
    @NotNull(message = "This field can not be null")
    private String address;
    @Past(message = "Please choose a date from the past")
    private LocalDate birthDate;
    @NotNull(message = "This field can not be null")
    private String postCode;
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Invalid gender")
    private String gender;
}
