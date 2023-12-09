package com.example.eticaret.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"userDetailsList", "products"})
@EqualsAndHashCode(exclude = {"userDetailsList", "products"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private BigDecimal balance;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserDetails> userDetailsList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;







    }

