package com.application.rest.services.implementations;

import com.application.rest.models.Benefit;
import com.application.rest.persistence.BenefitDAO;
import com.application.rest.services.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenefitServiceImplementation implements BenefitService {

    @Autowired
    private BenefitDAO benefitDAO;
    @Override
    public Optional<Benefit> findBenefitById(Long id) {
        return benefitDAO.findBenefitById(id);
    }

    @Override
    public List<Benefit> findAllBenefits() {
        return benefitDAO.findAllBenefits();
    }

    @Override
    public void saveBenefit(Benefit benefit) {
        benefitDAO.saveBenefit(benefit);
    }

    @Override
    public void deleteBenefit(Long id) {
        benefitDAO.deleteBenefit(id);
    }

    @Override
    public void updateBenefit(Benefit benefit) {
        benefitDAO.updateBenefit(benefit);
    }
}
