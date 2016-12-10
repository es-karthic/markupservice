package com.example.markupservice.common;

import com.example.markupservice.exception.InvalidNumberException;

/**
 * Created by work on 12/10/16.
 */
public class Util {
    public static final String PRICE_NEGATIVE_EXCEPTION = "Price value cannot be in Negative";
    public static final String PERSON_NEGATIVE_EXCEPTION = "Number of person cannot be a Negative value";
    public static double inPercentage(double value) {
        return value / 100;
    }

    public static void validateData(double price, int noOfPeople) throws InvalidNumberException {
        if(price<0) {
            throw new InvalidNumberException(PRICE_NEGATIVE_EXCEPTION);
        }
        if(noOfPeople <0)   {
           throw new InvalidNumberException(PERSON_NEGATIVE_EXCEPTION);
        }
    }
}
