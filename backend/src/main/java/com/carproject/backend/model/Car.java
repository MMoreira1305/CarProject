package com.carproject.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// Modelo de carro
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Car {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String plate;

    @NotNull
    private Long odometer;

    @NotNull
    private String color;

    @NotNull
    private Double price;

    @NotNull
    private int quantity;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
