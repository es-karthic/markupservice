package com.example.markupservice.service;


import com.example.markupservice.exception.InvalidNumberException;

public interface IMarkupPriceCalculatorService {
    public double calculateFlatPrice();
    public double calculatorPersonPrice();
    public double calculateTotalMarkupPrice() throws InvalidNumberException;
}
