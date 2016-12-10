package com.example.markupservice.service;

import com.example.markupservice.common.Util;
import com.example.markupservice.exception.InvalidNumberException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DrugMarkupService implements IMaterialMarkupCalculatorService {

    @Value("${DRUGS}")
    private double drugMarkupPercent;

    public double getDrugMarkupPercent() {
        return drugMarkupPercent;
    }

    public void setDrugMarkupPercent(double drugMarkupPercent) {
        this.drugMarkupPercent = drugMarkupPercent;
    }

    @Override
    public double calculateMaterialMarkupPrice(double baseFlatPrice) throws InvalidNumberException {
        if(baseFlatPrice < 0 )
            throw new InvalidNumberException(Util.PRICE_NEGATIVE_EXCEPTION);
        return baseFlatPrice * Util.inPercentage(getDrugMarkupPercent());
    }
}
