
package com.example.markupservice.config;

import com.example.markupservice.common.MarkupServiceTypes;
import com.example.markupservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MarkupServiceConfiguration {

    @Autowired
    private FoodMarkupService foodMarkupService;
    @Autowired
    private ElectronicsMarkupService electronicsMarkupService;
    @Autowired
    private DrugMarkupService drugMarkupService;
    @Autowired
    private OtherMarkupService otherMarkupService;

    private Map<MarkupServiceTypes,IMaterialMarkupCalculatorService> serviceMap;


    @Bean
    public Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> serviceMap()   {
            Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> cserviceMap = getServiceMap();
            cserviceMap.put(MarkupServiceTypes.FOOD, foodMarkupService);
            cserviceMap.put(MarkupServiceTypes.ELECTRONICS, electronicsMarkupService);
            cserviceMap.put(MarkupServiceTypes.DRUGS, drugMarkupService);
            cserviceMap.put(MarkupServiceTypes.OTHER, otherMarkupService);
            return cserviceMap;
    }

    public FoodMarkupService getFoodMarkupService() {
        return foodMarkupService;
    }

    public void setFoodMarkupService(FoodMarkupService foodMarkupService) {
        this.foodMarkupService = foodMarkupService;
    }

    public ElectronicsMarkupService getElectronicsMarkupService() {
        return electronicsMarkupService;
    }

    public void setElectronicsMarkupService(ElectronicsMarkupService electronicsMarkupService) {
        this.electronicsMarkupService = electronicsMarkupService;
    }

    public DrugMarkupService getDrugMarkupService() {
        return drugMarkupService;
    }

    public void setDrugMarkupService(DrugMarkupService drugMarkupService) {
        this.drugMarkupService = drugMarkupService;
    }

    public OtherMarkupService getOtherMarkupService() {
        return otherMarkupService;
    }

    public void setOtherMarkupService(OtherMarkupService otherMarkupService) {
        this.otherMarkupService = otherMarkupService;
    }

    public Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> getServiceMap() {
        if(serviceMap == null)  {
            serviceMap = new HashMap<MarkupServiceTypes, IMaterialMarkupCalculatorService>();
        }
        return serviceMap;
    }

    public void setServiceMap(Map<MarkupServiceTypes, IMaterialMarkupCalculatorService> serviceMap) {
        this.serviceMap = serviceMap;
    }
}

