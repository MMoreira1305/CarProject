package com.carproject.backend.model;

import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
public class LevelAccess {

    @Id
    private Long id;
    private String nivel;
}
