package com.fabricio.calculator.service;

import com.fabricio.calculator.dto.CalculationRequest;
import com.fabricio.calculator.dto.CalculationResponse;
import com.fabricio.calculator.model.Calculation;
import com.fabricio.calculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final CalculationRepository calculationRepository;

    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public CalculationResponse add (CalculationRequest request){
        Double addition = request.number1() + request.number2();
        saveCalculation(request.number1(), request.number2(), "ADD", addition, null);
        return new CalculationResponse(addition);
    }

    public CalculationResponse subtract(CalculationRequest request){
        Double subtraction = request.number1() - request.number2();
        saveCalculation(request.number1(), request.number2(), "SUBTRACT", subtraction, null);
        return new CalculationResponse(subtraction);
    }

    public CalculationResponse multiply(CalculationRequest request){
        Double multiplication = request.number1() * request.number2();
        saveCalculation(request.number1(), request.number2(), "MULTIPLY", multiplication, null);
        return new CalculationResponse(multiplication);
    }

    public CalculationResponse divide(CalculationRequest request){
        if ( request.number2() == 0) {
            String message = "Não é possível dividir por zero";
            saveCalculation(request.number1(), request.number2(), "DIVIDE", null, message);
            return new CalculationResponse(null, message);
        }
        Double division = request.number1() / request.number2();
        saveCalculation(request.number1(), request.number2(), "DIVIDE", division, null);
        return new CalculationResponse(division);
    }

    private void saveCalculation(
            Double number1,
            Double number2,
            String operation,
            Double result,
            String message
    ){
        Calculation calculation = new Calculation(number1, number2, operation, result, message);
        calculationRepository.save(calculation);
    }

}
