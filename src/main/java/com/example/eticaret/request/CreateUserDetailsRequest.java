package com.example.eticaret.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDetailsRequest {
    private Long id;
    @NotNull(message = "Adress must not be empty")
    private String address;
    @Past(message = "Please choose a date from the past.")
    private LocalDate birthDate;
    @NotNull(message = "This field can not be null")
    private String postCode;
    private String gender;


}
