package com.example.eticaret.dto;

import com.example.eticaret.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto {
    @NotBlank(message = "Address can not be empty")
    private String address;
    @Past(message = "Please choose a date from the past")
    private LocalDate birthDate;
    private String postCode;
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Invalid gender")
    private String gender;
    

}
