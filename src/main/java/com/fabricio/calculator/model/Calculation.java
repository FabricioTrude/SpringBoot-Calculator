package com.fabricio.calculator.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="calculation_history")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double number1;

    @Column(nullable = false)
    private Double number2;

    @Column(nullable = false, length = 20)
    private String operation;

    private Double result;

    @Column(length = 255)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Calculation() {
    }

    public Calculation(Double number1, Double number2, String operation, Double result, String message) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
