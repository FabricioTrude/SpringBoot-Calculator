package com.fabricio.calculator.controller;

import com.fabricio.calculator.dto.CalculationRequest;
import com.fabricio.calculator.dto.CalculationResponse;
import com.fabricio.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/add")
    public CalculationResponse add(@RequestBody @Valid CalculationRequest request) {
        return calculatorService.add(request);
    }

    @PostMapping("/subtract")
    public CalculationResponse subtract(@RequestBody @Valid CalculationRequest request) {
        return calculatorService.subtract(request);
    }

    @PostMapping("/multiply")
    public CalculationResponse multiply(@RequestBody @Valid CalculationRequest request) {
        return calculatorService.multiply(request);
    }

    @PostMapping("/divide")
    public CalculationResponse divide(@RequestBody @Valid CalculationRequest request) {
        return calculatorService.divide(request);
    }
}