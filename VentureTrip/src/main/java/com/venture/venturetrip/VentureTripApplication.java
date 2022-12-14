package com.venture.venturetrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.venture")
public class VentureTripApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentureTripApplication.class, args);
    }

}
