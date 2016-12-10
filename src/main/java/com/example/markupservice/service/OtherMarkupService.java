package com.example.markupservice.service;

import com.example.markupservice.exception.InvalidNumberException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OtherMarkupService implements  IMaterialMarkupCalculatorService{

    @Value("${OTHERS}")
    private double otherMarkupPercent;

    @Override
    public double calculateMaterialMarkupPrice(double baseFlatPrice) throws InvalidNumberException {
        if(baseFlatPrice < 0 ) {
            throw new InvalidNumberException("Price value cannot be in Negative");
        }
        return baseFlatPrice * getOtherMarkupPercent();
    }

    public double getOtherMarkupPercent() {
        return otherMarkupPercent;
    }

    public void setOtherMarkupPercent(double otherMarkupPercent) {
        this.otherMarkupPercent = otherMarkupPercent;
    }
}
