package com.example.markupservice.service;

import com.example.markupservice.exception.InvalidNumberException;

/**
 * Created by work on 12/10/16.
 */
public interface IMaterialMarkupCalculatorService {
    public double calculateMaterialMarkupPrice(double baseFlatPrice) throws InvalidNumberException;
}
