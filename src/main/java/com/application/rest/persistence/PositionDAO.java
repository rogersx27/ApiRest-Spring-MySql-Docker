package com.application.rest.persistence;

import com.application.rest.models.Position;

import java.util.List;
import java.util.Optional;

public interface PositionDAO {

    Optional<Position> findPositionById(Long id);

    List<Position> findAllPosition();

    void savePosition(Position position);

    void deletePosition(Long id);

    void updatePosition(Position position);
}
