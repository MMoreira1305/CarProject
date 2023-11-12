package com.carproject.backend.repo;

import com.carproject.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findByName(String name);

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String Email);

    List<User> findAll();
}
