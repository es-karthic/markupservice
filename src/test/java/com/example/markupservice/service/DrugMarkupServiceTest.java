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
public class DrugMarkupServiceTest {


        @Autowired
        private DrugMarkupService drugMarkupService;

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Before
        public void setup() {}

        @Test
        public void testWrongMarkupPercentage()  {
            assertNotEquals(5, drugMarkupService.getDrugMarkupPercent(),1);
        }

        @Test
        public void testMarkupPercentage()  {
            assertEquals(7.5, drugMarkupService.getDrugMarkupPercent(),1);
        }

        @Test
        public void testCalculateDrugMarkup() throws InvalidNumberException {
            assertEquals(102.37, drugMarkupService.calculateMaterialMarkupPrice(1364.9895),1);
        }

        @Test
        public void testCalculateDrugMarkupUseCase2() throws InvalidNumberException {
            assertEquals(112.5, drugMarkupService.calculateMaterialMarkupPrice(1500),1);
        }

        @Test
        public void testCalculateDrugMarkupNegative() throws InvalidNumberException {
            thrown.expect(InvalidNumberException.class);
            thrown.expectMessage("Price value cannot be in Negative");
            assertEquals(195, drugMarkupService.calculateMaterialMarkupPrice(-1500),1);
        }

    }


