package com.javakar.springdemomaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringDemoMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoMasterApplication.class, args);
        System.out.println("");
    }

}
