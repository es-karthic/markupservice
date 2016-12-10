package com.example.markupservice.service;

import com.example.markupservice.common.MarkupServiceTypes;
import com.example.markupservice.exception.InvalidNumberException;
import com.example.markupservice.model.MarkupServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MarkupPriceCalculatorServiceImpl implements IMarkupPriceCalculatorService {

    @Value("${FLAT}")
    private double flat;

    @Value("${PERSON}")
    private double personPercent;


    private MarkupServiceModel markupServiceModel;

    @Autowired
    private Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> serviceMap;

    public MarkupPriceCalculatorServiceImpl(MarkupServiceModel model) throws InvalidNumberException {
        if(model.getPrice()<0) {
            throw new InvalidNumberException("Price value cannot be in Negative");
        }
        this.markupServiceModel = model;
    }

    @Override
    public double calculateFlatPrice() {
        return 0;
    }

    @Override
    public double calculatorPersonPrice() {
        return 0;
    }

    @Override
    public double calculateTotalMarkupPrice() {
        return 0;
    }

    public double getFlat() {
        return flat;
    }

    public void setFlat(double flat) {
        this.flat = flat;
    }

    public double getPersonPercent() {
        return personPercent;
    }

    public void setPersonPercent(double personPercent) {
        this.personPercent = personPercent;
    }

    public MarkupServiceModel getMarkupServiceModel() {
        return markupServiceModel;
    }

    public void setMarkupServiceModel(MarkupServiceModel markupServiceModel) {
        this.markupServiceModel = markupServiceModel;
    }

    public Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> serviceMap) {
        this.serviceMap = serviceMap;
    }
}