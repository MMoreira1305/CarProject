package com.carproject.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class LevelAccess {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
}
