package com.application.rest.controllers;

import com.application.rest.controllers.dto.PositionDTO;
import com.application.rest.models.Position;
import com.application.rest.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

            return ResponseEntity.ok(positions);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (positionOptional.isPresent()) {
                Position position = positionOptional.get();

                PositionDTO positionDTO = PositionDTO.builder()
                        .id(position.getId())
                        .title(position.getTitle())
                        .description(position.getDescription())
                        .salary(position.getSalary())
                        .build();

                return ResponseEntity.ok(positionDTO);
            }
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find/title/{title}")
    public ResponseEntity<?> findByTitle(@PathVariable String title) {
        try {
            Optional<Position> positionOptional = positionService.findPositionByTitle(title);

            if (positionOptional.isPresent()) {
                Position position = positionOptional.get();

                PositionDTO positionDTO = PositionDTO.builder()
                        .id(position.getId())
                        .title(position.getTitle())
                        .description(position.getDescription())
                        .salary(position.getSalary())
                        .build();

                return ResponseEntity.ok(positionDTO);
            }
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePosition(@RequestBody PositionDTO positionDTO) {
        try {
            if (positionDTO.getTitle().isBlank() || positionDTO.getDescription().isEmpty() || positionDTO.getSalary() == null){
                return ResponseEntity.badRequest().build();
            }

            Position position = Position.builder()
                    .title(positionDTO.getTitle())
                    .description(positionDTO.getDescription())
                    .salary(positionDTO.getSalary())
                    .build();

            positionService.savePosition(position);

            return ResponseEntity.ok("Position saved successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePosition(@PathVariable Long id, @RequestBody PositionDTO positionDTO) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (positionOptional.isPresent()) {
                Position position = positionOptional.get();
                position.setTitle(positionDTO.getTitle());
                position.setDescription(positionDTO.getDescription());
                position.setSalary(positionDTO.getSalary());
                positionService.updatePosition(position);
                return ResponseEntity.ok("Position updated successfully");
            }
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePosition(@PathVariable Long id) {
        try {
            Optional<Position> positionOptional = positionService.findPositionById(id);

            if (positionOptional.isPresent()) {
                positionService.deletePosition(id);
                return ResponseEntity.ok("Position deleted successfully");
            }
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
