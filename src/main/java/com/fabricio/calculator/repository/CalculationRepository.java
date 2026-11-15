package com.fabricio.calculator.repository;

import com.fabricio.calculator.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository
    extends JpaRepository<Calculation, Long> {

}
