package com.carproject.backend.model;

import jakarta.persistence.*;
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

    private String date;

    private String hour;
    private String moviment_type;
    private int quantity;

    public Document(Car car, String date, String hour, String moviment_type, int quantity){
        this.car = car;
        this.date = date;
        this.hour = hour;
        this.moviment_type = moviment_type;
        this.quantity = quantity;
    }
}
