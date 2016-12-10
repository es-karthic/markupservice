package com.example.markupservice.service;

import com.example.markupservice.exception.InvalidNumberException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OtherMarkupServiceTest {

    @Autowired
    private OtherMarkupService otherMarkupService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {}

    @Test
    public void testWrongMarkupPercentage()  {
        assertNotEquals(5, otherMarkupService.getOtherMarkupPercent(),1);
    }

    @Test
    public void testMarkupPercentage()  {
        assertEquals(0, otherMarkupService.getOtherMarkupPercent(),1);
    }

    @Test
    public void testCalculateOtherMarkup() throws InvalidNumberException {
        assertEquals(0, otherMarkupService.calculateMaterialMarkupPrice(5703.6),1);
    }

    @Test
    public void testCalculateOtherMarkupUseCase2() throws InvalidNumberException {
        assertEquals(0, otherMarkupService.calculateMaterialMarkupPrice(1500),1);
    }

    @Test
    public void testCalculateOtherMarkupNegative() throws InvalidNumberException {
        thrown.expect(InvalidNumberException.class);
        thrown.expectMessage("Price value cannot be in Negative");
        assertEquals(195, otherMarkupService.calculateMaterialMarkupPrice(-1500),1);
    }
}
