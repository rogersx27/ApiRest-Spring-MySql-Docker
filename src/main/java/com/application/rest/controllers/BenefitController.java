package com.application.rest.controllers;

import com.application.rest.controllers.dto.BenefitDTO;
import com.application.rest.models.Benefit;
import com.application.rest.services.BenefitService;
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
@CrossOrigin
@RestController
@RequestMapping("/api/v1/benefits")
public class BenefitController {

    @Autowired
    private BenefitService benefitService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllBenefits() {
        List<BenefitDTO> benefits = benefitService.findAllBenefits()
                .stream()
                .map(benefit -> BenefitDTO.builder()
                        .id(benefit.getId())
                        .description(benefit.getDescription())
                        .employeeHasBenefits(benefit.getEmployeeHasBenefits())
                        .build())
                .toList();

        log.info("All benefits found");
        return ResponseEntity.ok(benefits);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isEmpty()) {
            log.warning("Benefit with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        Benefit benefit = benefitOptional.get();

        BenefitDTO benefitDTO = BenefitDTO.builder()
                .id(benefit.getId())
                .description(benefit.getDescription())
                .build();

        log.info("Benefit with id " + id + " found");
        return ResponseEntity.ok(benefitDTO);
    }

    @PostMapping("/save")
    @SneakyThrows(value = {URISyntaxException.class, IllegalArgumentException.class})
    public ResponseEntity<?> saveBenefit(@RequestBody BenefitDTO benefitDTO) throws URISyntaxException {

        benefitDTO.isValid();

        Benefit benefit = Benefit.builder()
                .description(benefitDTO.getDescription())
                .build();

        benefitService.saveBenefit(benefit);

        log.info("Benefit saved");
        return ResponseEntity.created(new URI("/api/v1/benefits/find/" + benefit.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBenefit(@PathVariable Long id, @RequestBody BenefitDTO benefitDTO){
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isEmpty()) {
            log.warning("Benefit with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        Benefit benefit = benefitOptional.get();
        benefit.setDescription(benefitDTO.getDescription());
        benefitService.updateBenefit(benefit);

        log.info("Benefit updated");
        return ResponseEntity.ok("Update success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBenefit(@PathVariable Long id){
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isEmpty()) {
            log.warning("Benefit with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        benefitService.deleteBenefit(id);

        log.info("Benefit with id " + id + " deleted");
        return ResponseEntity.ok("Delete success");
    }
}
