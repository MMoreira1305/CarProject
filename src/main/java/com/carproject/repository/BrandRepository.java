package com.carproject.repository;

import com.carproject.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

    @Override
    Optional<Brand> findById(Long id);

    Optional<Brand> findByName(String nome);
    List<Brand> findAll();
}
