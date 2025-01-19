package com.enviro.assessment.grad001.trevordamoyi.controllers.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Register {
    private String email;
    private String password;
    private String name;
    private  String surname;
    private Integer communityleader;
    private String role;
    private String area;

    @JsonGetter(value = "email")
    public String getEmail() {return email;}
    @JsonSetter(value = "email")
    public void setEmail(String email) {this.email = email;}
    @JsonGetter(value = "password")
    public String getPassword() {return password;}
    @JsonSetter(value = "password")
    public void setPassword(String password) {this.password = password;}
    @JsonGetter(value = "name")
    public String getName() {return name;}
    @JsonSetter(value = "name")
    public void setName(String name) {this.name = name;}
    @JsonGetter(value = "surname")
    public String getSurname() {return surname;}
    @JsonSetter(value = "surname")
    public void setSurname(String surname) {this.surname = surname;}
    @JsonGetter(value = "leader")
    public Integer getCommunityleader() {return communityleader;}
    @JsonSetter(value = "leader")
    public void setCommunityleader(Integer communityleader) {this.communityleader = communityleader;}
    @JsonGetter(value = "role")
    public String getRole() {return role;}
    @JsonSetter(value = "role")
    public void setRole(String role) {this.role = role;}
    @JsonGetter(value = "area")
    public String getArea() {return area;}
    @JsonSetter(value = "area")
    public void setArea(String area) {this.area = area;}
}
