package com.um.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.um.auth.Jwt;
import com.um.models.User;
import com.um.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User response =  userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (response == null){
            return "Incorrect email or password!";
        }
        else{
            Jwt token = new Jwt();
            token.generateToken(response);
            return "Welcome " + response.getName() + " " + response.getLastname() + "! " + token.generateToken(response);}
    }
}
