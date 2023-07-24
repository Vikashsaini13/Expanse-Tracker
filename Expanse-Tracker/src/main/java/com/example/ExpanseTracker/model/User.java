package com.example.ExpanseTracker.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotBlank
    private String userName;

    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$")
    private String userEmail;

    private String userPassword;
}
