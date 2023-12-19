package com.example.eticaret.model;

import com.example.eticaret.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private LocalDate birthDate;
    private String postCode;
    private String gender;

    @OneToOne
    private User user;


    public UserDetails(Long id, String address, String gender, LocalDate birthDate, String postCode, User user) {
        this.id=id;
        this.address=address;
        this.gender=gender;
        this.birthDate=birthDate;
        this.postCode=postCode;
        this.user=user;
    }

    public UserDetails(String address, String gender, LocalDate birthDate, String postCode, User user) {
        this.address=address;
        this.gender=gender;
        this.birthDate=birthDate;
        this.postCode=postCode;
        this.user=user;
    }


}
