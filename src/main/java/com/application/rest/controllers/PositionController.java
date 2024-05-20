package com.application.rest.controllers;

import com.application.rest.controllers.dto.PositionDTO;
import com.application.rest.models.Position;
import com.application.rest.services.PositionService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllPositions() {
        try {
            List<PositionDTO> positions = positionService.findAllPosition()
                    .stream()
                    .map(position -> PositionDTO.builder()
                            .id(position.getId())
                            .title(position.getTitle())
                            .description(position.getDescription())
                            .salary(position.getSalary())
                            .build())
                    .toList();

            log.info("All positions found");
            return ResponseEntity.ok(positions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (!positionOptional.isPresent()) {
                log.warning("Position with id " + id + " not found");
                return ResponseEntity.notFound().build();
            }

            Position position = positionOptional.get();

            PositionDTO positionDTO = PositionDTO.builder()
                    .id(position.getId())
                    .title(position.getTitle())
                    .description(position.getDescription())
                    .salary(position.getSalary())
                    .build();

            log.info("Position with id " + id + " found");
            return ResponseEntity.ok(positionDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/title/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title) {
        try {
            Optional<Position> positionOptional = positionService.findPositionByTitle(title);

            if (!positionOptional.isPresent()) {
                log.warning("Position with title " + title + " not found");
                return ResponseEntity.notFound().build();
            }

            Position position = positionOptional.get();

            PositionDTO positionDTO = PositionDTO.builder()
                    .id(position.getId())
                    .title(position.getTitle())
                    .description(position.getDescription())
                    .salary(position.getSalary())
                    .build();

            log.info("Position with title " + title + " found");
            return ResponseEntity.ok(positionDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save")
    @SneakyThrows(value = {URISyntaxException.class, IllegalArgumentException.class})
    public ResponseEntity<?> savePosition(@RequestBody PositionDTO positionDTO) throws URISyntaxException {

        positionDTO.isValid();

        Position position = Position.builder()
                .title(positionDTO.getTitle())
                .description(positionDTO.getDescription())
                .salary(positionDTO.getSalary())
                .build();

        positionService.savePosition(position);

        log.info("Position saved");
        return ResponseEntity.created(new URI("/api/v1/positions/find/" + position.getId())).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable Long id, @RequestBody PositionDTO positionDTO) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (!positionOptional.isPresent()) {
                log.warning("Position with id " + id + " not found");
                return ResponseEntity.notFound().build();
            }

            Position position = positionOptional.get();
            position.setTitle(positionDTO.getTitle());
            position.setDescription(positionDTO.getDescription());
            position.setSalary(positionDTO.getSalary());
            positionService.updatePosition(position);

            log.info("Position: " + position.getId() + " updated");
            return ResponseEntity.ok("Position updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable Long id) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (!positionOptional.isPresent()) {
                log.warning("Position with id " + id + " not found");
                return ResponseEntity.notFound().build();
            }

            positionService.deletePosition(id);

            log.info("Position with id " + id + " deleted");
            return ResponseEntity.ok("Position deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
