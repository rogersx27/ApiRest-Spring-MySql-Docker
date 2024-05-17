package com.application.rest.controllers;

import com.application.rest.controllers.dto.BenefitDTO;
import com.application.rest.models.Benefit;
import com.application.rest.services.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

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
        return ResponseEntity.ok(benefits);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isPresent()) {
            Benefit benefit = benefitOptional.get();

            BenefitDTO benefitDTO = BenefitDTO.builder()
                    .id(benefit.getId())
                    .description(benefit.getDescription())
                    .build();

            return ResponseEntity.ok(benefitDTO);
        }
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBenefit(@RequestBody BenefitDTO benefitDTO) throws URISyntaxException {

        if (benefitDTO.getDescription().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        Benefit benefit = Benefit.builder()
                .description(benefitDTO.getDescription())
                .build();

        benefitService.saveBenefit(benefit);

        return ResponseEntity.created(new URI("/api/v1/benefits")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBenefit(@PathVariable Long id, @RequestBody BenefitDTO benefitDTO){
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isPresent()) {
            Benefit benefit = benefitOptional.get();
            benefit.setDescription(benefitDTO.getDescription());
            benefitService.updateBenefit(benefit);
            return ResponseEntity.ok("Update success");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBenefit(@PathVariable Long id){
        Optional<Benefit> benefitOptional = benefitService.findBenefitById(id);

        if (benefitOptional.isPresent()) {
            benefitService.deleteBenefit(id);
            return ResponseEntity.ok("Delete success");
        }
        return ResponseEntity.notFound().build();
    }
}
