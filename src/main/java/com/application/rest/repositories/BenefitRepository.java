package com.application.rest.repositories;

import com.application.rest.models.Benefit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRepository extends CrudRepository<Benefit, Long>{
}
