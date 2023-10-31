package com.carproject.backend.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

// Modelo de carro
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Car {

    @Id
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
