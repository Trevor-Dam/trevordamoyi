package com.enviro.assessment.grad001.trevordamoyi.controllers;

import com.enviro.assessment.grad001.trevordamoyi.Secrecy;
import com.enviro.assessment.grad001.trevordamoyi.controllers.dto.UserDto;
import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import com.enviro.assessment.grad001.trevordamoyi.controllers.models.Login;
import com.enviro.assessment.grad001.trevordamoyi.controllers.models.Register;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.CommunityMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.mappers.UserMapper;
import com.enviro.assessment.grad001.trevordamoyi.controllers.services.CommunityService;
import com.enviro.assessment.grad001.trevordamoyi.controllers.services.UserService;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    private final UserMapper userMapper;

    private final CommunityMapper communityMapper;

    @Autowired
    private CommunityService communityService;

    public UsersController(CommunityMapper communityMapper, UserMapper userMapper) {
        this.communityMapper = communityMapper;
        this.userMapper = userMapper;
    }

    @PostMapping("/user/login")
    @JsonSetter(nulls = Nulls.FAIL)
    public HttpEntity<UserDto> login(@RequestBody Login login) {
        UserDto userDto;
        String hash;
        User user;
        try {
            hash = Secrecy.generateStorngPasswordHash(login.getPassword());
            if (!userService.existsByEmailAndPassword(login.getUsername(), hash)) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            else {
                user = userService.findByEmailAndPassword
                        (login.getUsername(), hash);
                userDto = userMapper.toDto(user);
                return new ResponseEntity<>(userDto, HttpStatus.OK);
            }

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }


    @PostMapping("/user/register")
    @JsonSetter(nulls = Nulls.FAIL)
    public HttpEntity<UserDto> register(@RequestBody Register register) {
        int regUsers = (int) userService.countUsers();
        regUsers++;
        String hashedPassword = "";
        try {
            hashedPassword = Secrecy.generateStorngPasswordHash(register.getPassword());
            if (userService.existsByEmail(register.getEmail())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            UserDto userDto = new UserDto(
                    regUsers,
                    register.getEmail(),
                    hashedPassword,
                    register.getName(),
                    register.getSurname(),
                    register.getCommunityleader(),
                    0,
                    register.getRole(),
                    communityMapper.toDto(communityService.findByArea(register.getArea()))
            );

            User user = userService.saveAndFlush(userMapper.toEntity(userDto));

            return new ResponseEntity<>(userDto, HttpStatus.CREATED);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }



    }

}

