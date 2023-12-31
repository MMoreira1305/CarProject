package com.carproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

// Modelo de marca
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Brand {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;

    @NotNull
    private String name;

    public Brand(String name){
        this.name = name;
    }
}
