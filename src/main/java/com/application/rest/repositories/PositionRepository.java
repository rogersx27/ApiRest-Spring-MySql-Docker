package com.application.rest.repositories;

import com.application.rest.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
    Optional<Position> findByTitle(String title);
}
