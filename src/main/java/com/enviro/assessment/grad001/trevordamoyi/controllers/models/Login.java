package com.enviro.assessment.grad001.trevordamoyi.controllers.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Login{
    private String username;
    private String password;

    @JsonGetter(value = "email")
    public String getUsername() {
        return username;
    }
    @JsonSetter(value = "email")
    public void setUsername(String username) {
        this.username = username;
    }
    @JsonGetter(value = "password")
    public String getPassword() {
        return password;
    }
    @JsonSetter(value = "password")
    public void setPassword(String password) {
        this.password = password;
    }
}
