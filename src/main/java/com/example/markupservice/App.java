package com.example.markupservice;

import com.example.markupservice.service.DrugMarkupService;
import com.example.markupservice.service.FoodMarkupService;
import com.example.markupservice.service.MarkupPriceCalculatorServiceImpl;
import com.example.markupservice.service.OtherMarkupService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class,args);
        FoodMarkupService service = ctx.getBean(FoodMarkupService.class);
        DrugMarkupService drugMarkupService = ctx.getBean(DrugMarkupService.class);
        OtherMarkupService other = ctx.getBean(OtherMarkupService.class);
        MarkupPriceCalculatorServiceImpl impl = ctx.getBean(MarkupPriceCalculatorServiceImpl.class);
        System.out.println( "Hello World!" );
    }
}
