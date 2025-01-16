package com.enviro.assessment.grad001.trevordamoyi.controllers;

import com.enviro.assessment.grad001.trevordamoyi.controllers.models.Login;
import com.enviro.assessment.grad001.trevordamoyi.dto.UserDto;
import com.enviro.assessment.grad001.trevordamoyi.migrations.User;
import com.enviro.assessment.grad001.trevordamoyi.repositories.UserRepository;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;
import org.hibernate.annotations.processing.SQL;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;

@RestController
public class UsersController {
    private final UserRepository userRepository;
    public UsersController(UserRepository userRepository) {
       this.userRepository = userRepository;
    }
    @PostMapping("/api/login")
    public UserDto login(@RequestBody Login login) {
        UserDto userDto = null;
        ResponseBody responseBody = null;
        if (userRepository.existsByEmailAndPassword
                (login.getUsername(), login.getPassword())) {
            User user = userRepository.findByEmailAndPassword
                    (login.getUsername(), login.getPassword());
            userDto = new UserDto(
                    user.getId(),
                    user.getEmail(),
                    user.getName(),
                    user.getSurname(),
                    user.getCommunityleader(),
                    user.getScore(),
                    user.getUserrole()
            );
        }
        return userDto;
    }
}

