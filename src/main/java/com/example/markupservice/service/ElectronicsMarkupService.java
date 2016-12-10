package com.example.markupservice.service;

import com.example.markupservice.common.Util;
import com.example.markupservice.exception.InvalidNumberException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ElectronicsMarkupService implements IMaterialMarkupCalculatorService{

    @Value("${ELECTORNICS}")
    private double electronicsMarkupPercent;

    @Override
    public double calculateMaterialMarkupPrice(double baseFlatPrice) throws InvalidNumberException {
        if(baseFlatPrice <0) {
            throw new InvalidNumberException("Price value cannot be in Negative");
        }
        return baseFlatPrice * Util.inPercentage(getElectronicsMarkupPercent());
    }

    public double getElectronicsMarkupPercent() {
        return electronicsMarkupPercent;
    }

    public void setElectronicsMarkupPercent(double electronicsMarkupPercent) {
        this.electronicsMarkupPercent = electronicsMarkupPercent;
    }
}
