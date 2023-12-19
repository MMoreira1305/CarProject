package com.carproject.backend.repository;

import com.carproject.backend.model.Car;
import com.carproject.backend.model.LevelAccess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelAccessRepository extends CrudRepository<LevelAccess, Long> {

    Optional<LevelAccess> findById(Long id);

    Optional<Car> findByRole(String level);
    List<LevelAccess> findAll();
}
