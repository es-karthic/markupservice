package com.example.markupservice.service;

import com.example.markupservice.model.MarkupServiceModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarkupPriceCalculatorServiceImplTest {

    @Autowired
    private MarkupPriceCalculatorServiceImpl markupPriceCalculatorServiceImpl;

    private MarkupServiceModel model;

    @Before
    public void setup() {
        model = new MarkupServiceModel(1299,3,"food");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    @Test
    public void testCalculateTotalMarkupPrice() {
        assertEquals(1591.58, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }
    
}
