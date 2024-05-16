package com.application.rest.persistence.implementations;

import com.application.rest.models.Position;
import com.application.rest.persistence.PositionDAO;
import com.application.rest.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PositionDAOImplement implements PositionDAO {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public Optional<Position> findPositionById(Long id) {
        return positionRepository.findById(id);
    }

    @Override
    public List<Position> findAllPosition() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }

    @Override
    public void updatePosition(Position position) {
        positionRepository.save(position);
    }
}
