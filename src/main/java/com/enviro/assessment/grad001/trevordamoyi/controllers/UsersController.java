package com.enviro.assessment.grad001.trevordamoyi.controllers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.models.ModelLogin;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.hibernate.annotations.processing.SQL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;

@RestController
public class UsersController {
    Connection connection;
    public UsersController() {
       try {
            this.connection = DriverManager.getConnection("jdbc:h2:~/test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;DEFAULT_NULL_ORDERING=HIGH");
            System.out.println("Connection established");
        } catch (SQLException e) {
           e.printStackTrace();
       }
    }
    @PostMapping("/login")
    public void Login(@RequestBody ModelLogin login) {

    }
}

