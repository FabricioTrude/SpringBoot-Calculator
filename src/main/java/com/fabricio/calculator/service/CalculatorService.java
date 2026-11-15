package com.fabricio.calculator.service;

import com.fabricio.calculator.dto.CalculationRequest;
import com.fabricio.calculator.dto.CalculationResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public CalculationResponse add (CalculationRequest request){
        Double addition = request.number1() + request.number2();
        return new CalculationResponse(addition);
    }

    public CalculationResponse subtract(CalculationRequest request){
        Double subtraction = request.number1() - request.number2();
        return new CalculationResponse(subtraction);
    }

    public CalculationResponse multiply(CalculationRequest request){
        Double multiplication = request.number1() * request.number2();
        return new CalculationResponse(multiplication);
    }

    public CalculationResponse divide(CalculationRequest request){
        if ( request.number2() == 0) {
            return new CalculationResponse(null,
            "Não é possível dividir por zero");
        }
        Double division = request.number1() / request.number2();
        return new CalculationResponse(division);
    }

}
