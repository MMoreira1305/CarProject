package com.carproject.backend.repo;

import com.carproject.backend.model.LevelAccess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelAccessRepository extends CrudRepository<LevelAccess, Long> {
}
