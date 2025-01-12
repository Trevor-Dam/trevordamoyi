package com.enviro.assessment.grad001.trevordamoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@SpringBootApplication
public class TrevorDamoyiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrevorDamoyiApplication.class, args);
    }
    @Bean
    CommandLineRunner init(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
