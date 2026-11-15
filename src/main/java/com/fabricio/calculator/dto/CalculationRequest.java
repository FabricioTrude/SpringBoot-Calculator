package com.fabricio.calculator.dto;

import jakarta.validation.constraints.NotNull;

public record CalculationRequest(
        @NotNull( message = "O primeiro número é obrigatório")
        Double number1,
        @NotNull( message = "O segundo número também é obrigatório")
        Double number2
) {

}