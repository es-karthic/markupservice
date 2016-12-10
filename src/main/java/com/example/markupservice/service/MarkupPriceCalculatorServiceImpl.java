package com.example.markupservice.service;

import com.example.markupservice.common.MarkupServiceTypes;
import com.example.markupservice.common.Util;
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

    public MarkupPriceCalculatorServiceImpl()   {
        this.markupServiceModel = new MarkupServiceModel();
    }

    public MarkupPriceCalculatorServiceImpl(MarkupServiceModel model) throws InvalidNumberException {
        Util.validateData(model.getPrice(), model.getNoOfPeople());
        this.markupServiceModel = model;
    }

    @Override
    public double calculateFlatPrice() {
        return markupServiceModel.getPrice() + (Util.inPercentage(getFlat()) * markupServiceModel.getPrice());
    }

    @Override
    public double calculatorPersonPrice() {
        return calculateFlatPrice() * Util.inPercentage(getPersonPercent()) * markupServiceModel.getNoOfPeople();
    }

    @Override
    public double calculateTotalMarkupPrice() throws InvalidNumberException {
        IMaterialMarkupCalculatorService materialService = getServiceMap().get(markupServiceModel.getType());
        double flatPrice = calculateFlatPrice();
        double materialTypePrice = materialService.calculateMaterialMarkupPrice(flatPrice);
        double personPrice = calculatorPersonPrice();
        return flatPrice + personPrice + materialTypePrice;
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


    public void setMarkupServiceModel(MarkupServiceModel markupServiceModel) throws InvalidNumberException {
        Util.validateData(markupServiceModel.getPrice(), markupServiceModel.getNoOfPeople());
        this.markupServiceModel = markupServiceModel;
    }

    public Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> getServiceMap() {
        return serviceMap;
    }


    public void setServiceMap(Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> serviceMap) {
        this.serviceMap = serviceMap;
    }
}
