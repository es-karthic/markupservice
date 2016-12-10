package com.example.markupservice.service;

import com.example.markupservice.common.Util;
import com.example.markupservice.exception.InvalidNumberException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FoodMarkupService implements IMaterialMarkupCalculatorService {

    @Value("${FOOD}")
    private double foodMarkupPercent;

    @Override
    public double calculateMaterialMarkupPrice(double baseFlatPrice) throws InvalidNumberException {
        if(baseFlatPrice <0 )   {
            throw new InvalidNumberException(Util.PRICE_NEGATIVE_EXCEPTION);
        }
        return baseFlatPrice * Util.inPercentage(getFoodMarkupPercent());
    }


    public double getFoodMarkupPercent() {
        return foodMarkupPercent;
    }

    public void setFoodMarkupPercent(double foodMarkupPercent) {
        this.foodMarkupPercent = foodMarkupPercent;
    }
}
