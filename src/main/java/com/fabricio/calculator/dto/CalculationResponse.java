package com.fabricio.calculator.dto;

public record CalculationResponse (
    Double result,
    String message
){
    public CalculationResponse(Double result) {
        this(result, null);
    }
}