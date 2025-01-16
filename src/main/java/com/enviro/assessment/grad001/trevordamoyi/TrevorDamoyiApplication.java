package com.enviro.assessment.grad001.trevordamoyi;

import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@SpringBootApplication
public class TrevorDamoyiApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TrevorDamoyiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrevorDamoyiApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

    }
}
