package com.carproject.backend.repo;

import com.carproject.backend.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

    List<Document> findAll();

    Optional<Document> findById(Long id);
}
