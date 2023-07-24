package com.example.ExpanseTracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String title;
    private String description;
    @NotNull
    private Double price;
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    User user;
}
