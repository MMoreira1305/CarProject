package com.carproject.repository;

import com.carproject.model.Car;
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
    List<Car> findBySituation(String situation);
}
