package com.application.rest.services;

import com.application.rest.models.Benefit;

import java.util.List;
import java.util.Optional;

public interface BenefitService {

    Optional<Benefit> findBenefitById(Long id);

    List<Benefit> findAllBenefits();

    void saveBenefit(Benefit benefit);

    void deleteBenefit(Long id);

    void updateBenefit(Benefit benefit);
}
