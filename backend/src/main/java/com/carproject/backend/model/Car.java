package com.carproject.backend.model;

import jakarta.persistence.*;
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

    private String plate;
    private Long odometer;
    private String color;
    private Double price;
    private int quantity;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
