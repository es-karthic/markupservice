package com.example.markupservice.model;

import com.example.markupservice.common.MarkupServiceTypes;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarkupServiceModel {

    private double price;
    private int noOfPeople;
    private MarkupServiceTypes type;

    public MarkupServiceModel() {
        this.price = 0;
        this.noOfPeople = 0;
        this.type = MarkupServiceTypes.OTHER;
    }

    public MarkupServiceModel(double price, int noOfPeople, String materialType)    {
        this.price = price;
        this.noOfPeople = noOfPeople;
        materialType = materialType!=null? materialType.toUpperCase():"";
        if(MarkupServiceTypes.FOOD.name().equalsIgnoreCase(materialType))  {
            this.type = MarkupServiceTypes.FOOD;
        }   else if(MarkupServiceTypes.DRUGS.name().equalsIgnoreCase(materialType))  {
             this.type = MarkupServiceTypes.DRUGS;
        }   else if(MarkupServiceTypes.ELECTRONICS.name().equalsIgnoreCase(materialType))  {
             this.type = MarkupServiceTypes.ELECTRONICS;
        }   else {
                this.type = MarkupServiceTypes.OTHER;
        }
    }

    public MarkupServiceModel(double price, int noOfPeople, MarkupServiceTypes materialType)    {
        this.price = price;
        this.noOfPeople = noOfPeople;
        this.type = materialType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfPeople() {
        return noOfPeople;
    }

    public void setNoOfPeople(int noOfPeople) {
        this.noOfPeople = noOfPeople;
    }

    public MarkupServiceTypes getType() {
        return type;
    }

    public void setType(MarkupServiceTypes type) {
        this.type = type;
    }


}
