package com.example.eticaret.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Long amount;
    private String color;
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


  @OneToOne
  private Product product;

    public Product(BigDecimal price, String category, String color, Long amount, String name, User user) {
        this.price=price;
        this.category=category;
        this.color=color;
        this.amount=amount;
        this.name=name;
        this.user=user;
    }

    public Product(Long id, String name, String category, BigDecimal price, String color, Long amount, User user) {
        this.id=id;
        this.price=price;
        this.category=category;
        this.color=color;
        this.amount=amount;
        this.name=name;
        this.user=user;

    }
}
