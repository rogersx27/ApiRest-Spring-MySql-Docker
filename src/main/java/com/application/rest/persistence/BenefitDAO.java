package com.application.rest.persistence;

import com.application.rest.models.Benefit;

import java.util.List;
import java.util.Optional;

public interface BenefitDAO {

    Optional<Benefit> findBenefitById(Long id);

    List<Benefit> findAllBenefits();

    void saveBenefit(Benefit benefit);

    void deleteBenefit(Long id);

    void updateBenefit(Benefit benefit);
}
