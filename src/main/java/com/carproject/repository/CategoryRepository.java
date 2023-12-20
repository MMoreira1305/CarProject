package com.carproject.repository;

import com.carproject.model.Car;
import com.carproject.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findById(Long id);

    Optional<Car> findByNameCategory(String nameCategory);
    List<Category> findAll();
}
