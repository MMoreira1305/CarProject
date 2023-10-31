package com.carproject.backend.repo;

import com.carproject.backend.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
}
