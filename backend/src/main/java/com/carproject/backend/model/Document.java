package com.carproject.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Document {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placa")
    private Car car;
    private Date date;

    private String hour;
    private String moviment_type;
    private Long quantity;
    private Double total = this.car.getPrice() * this.quantity;
}
