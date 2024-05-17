package com.application.rest.services.implementations;

import com.application.rest.models.Position;
import com.application.rest.persistence.PositionDAO;
import com.application.rest.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImplementation implements PositionService {

    @Autowired
    private PositionDAO positionDAO;
    @Override
    public Optional<Position> findPositionById(Long id) {
        return positionDAO.findPositionById(id);
    }

    @Override
    public List<Position> findAllPosition() {
        return positionDAO.findAllPosition();
    }

    @Override
    public Optional<Position> findPositionByTitle(String title) {
        return positionDAO.findPositionByTitle(title);
    }

    @Override
    public void savePosition(Position position) {
        positionDAO.savePosition(position);
    }

    @Override
    public void deletePosition(Long id) {
        positionDAO.deletePosition(id);
    }

    @Override
    public void updatePosition(Position position) {
        positionDAO.updatePosition(position);
    }

}
