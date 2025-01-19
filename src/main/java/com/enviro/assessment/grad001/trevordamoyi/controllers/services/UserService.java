package com.enviro.assessment.grad001.trevordamoyi.controllers.services;

import com.enviro.assessment.grad001.trevordamoyi.controllers.migrations.User;
import com.enviro.assessment.grad001.trevordamoyi.controllers.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveAndFlush(User user) {
        return userRepository.saveAndFlush(user);
    }

    public long countUsers() {
        return userRepository.count();
    }

}
