package com.example.markupservice;

import com.example.markupservice.service.FoodMarkupService;
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
        System.out.println( "Hello World!" );
    }
}
