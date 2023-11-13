package com.carproject.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_car")
    private Car car;

    // Date is defined in varchar(10) because his max lenght is 10 char (2023-xx-xx)
    @NotNull
    @Column(columnDefinition = "varchar(10)")
    private String date;

    // Hour is defined in varchar(10) because his max lenght is 5 char (00:00)
    @NotNull
    @Column(columnDefinition = "varchar(5)")
    private String hour;

    // Moviment type is defined in varchar(9) because his max lenght is 9 char (INATIVADO)
    @NotNull
    @Column(columnDefinition = "varchar(9)")
    private String moviment_type;

    @NotNull
    private int quantity;

    public Document(Car car, String date, String hour, String moviment_type, int quantity){
        this.car = car;
        this.date = date;
        this.hour = hour;
        this.moviment_type = moviment_type;
        this.quantity = quantity;
    }
}
