package com.carproject.backend.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCategory;

    public Category(String nameCategory){
        this.nameCategory = nameCategory;
    }

}
