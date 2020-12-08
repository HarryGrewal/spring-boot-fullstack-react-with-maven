package com.cognizant.fullstack.test.springbootfullstackreactwithmaven.controller;

import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.model.User;
import com.cognizant.fullstack.test.springbootfullstackreactwithmaven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("getAllUsers")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}