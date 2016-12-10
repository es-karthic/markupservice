package com.example.markupservice.service;

import com.example.markupservice.exception.InvalidNumberException;
import com.example.markupservice.model.MarkupServiceModel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {

    }

    @Test
    public void testCalculatorBasePlusFlatMarkupPrice() throws InvalidNumberException {
        setupFood();
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
        assertEquals(1364.9895, markupPriceCalculatorServiceImpl.calculateFlatPrice(),1);
    }

    @Test
    public void testCalculatorPersonMarkupPrice() throws InvalidNumberException {
        setupFood();
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
        assertEquals(49.139, markupPriceCalculatorServiceImpl.calculatorPersonPrice(),1);
    }

    @Test
    public void testCalculateTotalMarkupPrice() throws InvalidNumberException {
        setupFood();
        assertEquals(1591.58, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }

    @Test
    public void testCalculatorBasePlusFlatMarkupPriceForDrugs() throws InvalidNumberException {
        setupDrugs();
        assertEquals(5703.6, markupPriceCalculatorServiceImpl.calculateFlatPrice(),1);
    }

    @Test
    public void testCalculatorPersonMarkupPriceForDrugs() throws InvalidNumberException {
        setupDrugs();
        assertEquals(68.4432, markupPriceCalculatorServiceImpl.calculatorPersonPrice(),1);
    }

    @Test
    public void testCalculateTotalMarkupPriceForDrugs() throws InvalidNumberException {
        setupDrugs();
        assertEquals(6199.81, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }

    @Test
    public void testCalculatorBasePlusFlatMarkupPriceForElectronics() throws InvalidNumberException {
        setupElectronics();
        assertEquals(5703.6, markupPriceCalculatorServiceImpl.calculateFlatPrice(),1);
    }

    @Test
    public void testCalculatorPersonMarkupPriceForElectronics() throws InvalidNumberException {
        setupElectronics();
        assertEquals(136.8864, markupPriceCalculatorServiceImpl.calculatorPersonPrice(),1);
    }

    @Test
    public void testCalculateTotalMarkupPriceForElectronics() throws InvalidNumberException {
        setupElectronics();
        assertEquals(5954.56, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }

    @Test
    public void testCalculatorBasePlusFlatMarkupPriceForOthers() throws InvalidNumberException {
        setupOthers();
        assertEquals(13079.798, markupPriceCalculatorServiceImpl.calculateFlatPrice(),1);
    }

    @Test
    public void testCalculatorPersonMarkupPriceForOthers() throws InvalidNumberException {
        setupOthers();
        assertEquals(627.83028, markupPriceCalculatorServiceImpl.calculatorPersonPrice(),1);
    }

    @Test
    public void testCalculateTotalMarkupPriceForOthers() throws InvalidNumberException {
        setupOthers();
        assertEquals(13707.63, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }

    @Test
    public void testCalculateTotalMarkupPriceForOthersUseCase2() throws InvalidNumberException {
        setupOthersUseCase2();
        assertEquals(0, markupPriceCalculatorServiceImpl.calculateTotalMarkupPrice(),1);
    }

    public void setupFood()  throws InvalidNumberException  {
        model = new MarkupServiceModel(1299.99,3, "food");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    public void setupElectronics()  throws InvalidNumberException  {
        model = new MarkupServiceModel(5432,2, "electronics");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    public void setupDrugs()   throws InvalidNumberException {
        model = new MarkupServiceModel(5432,1, "drugs");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    public void setupOthers()  throws InvalidNumberException  {
        model = new MarkupServiceModel(12456.95,4, "books");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    public void setupOthersUseCase2()  throws InvalidNumberException  {
        model = new MarkupServiceModel(0,0, "books");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }

    @Test
    public void setupInvalidModelOthers() throws InvalidNumberException   {
        model = new MarkupServiceModel(-12456.95,4, "books");
        thrown.expect(InvalidNumberException.class);
        thrown.expectMessage("Price value cannot be in Negative");
        markupPriceCalculatorServiceImpl.setMarkupServiceModel(model);
    }
}
