package com.carproject.backend.repo;

import com.carproject.backend.model.Car;
import com.carproject.backend.model.Category;
import com.carproject.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String nameCategory);
    List<User> findByName(String nameCategory);

    List<User> findAll();
}
