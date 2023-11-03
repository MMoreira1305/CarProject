package com.carproject.backend.repo;

import com.carproject.backend.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findById(Long id);

    Optional<Car> findByName(String nome);
    Optional<Car> findByPlate(String plate);
    List<Car> findAll();
}
