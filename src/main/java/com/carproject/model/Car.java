package com.carproject.model;

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
    @Column(
            columnDefinition = "varchar(9)"
    )
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

    // Is not necessary varchar(255) because the situation´s name finishs in 7 char.
    @Column(
            columnDefinition = "varchar(7) default 'ATIVO'"
    )
    private String situation;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
}
