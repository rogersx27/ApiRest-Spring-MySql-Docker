package com.application.rest.persistence.implementations;

import com.application.rest.models.Benefit;
import com.application.rest.persistence.BenefitDAO;
import com.application.rest.repositories.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BenefitDAOImplement implements BenefitDAO {

    @Autowired
    private BenefitRepository benefitRepository;
    @Override
    public Optional<Benefit> findBenefitById(Long id) {
        return benefitRepository.findById(id);
    }
    @Override
    public List<Benefit> findAllBenefits() {
        return (List<Benefit>) benefitRepository.findAll();
    }

    @Override
    public void saveBenefit(Benefit benefit) {
        benefitRepository.save(benefit);
    }

    @Override
    public void deleteBenefit(Long id) {
        benefitRepository.deleteById(id);
    }

    @Override
    public void updateBenefit(Benefit benefit) {
        benefitRepository.save(benefit);
    }
}
