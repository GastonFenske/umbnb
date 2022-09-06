package com.um.controller;
import com.um.models.User;
import com.um.auth.Jwt;
import com.um.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userRepository.save(user);
        Jwt token = new Jwt();
        return user.getName() + " " + user.getLastname() + " have registered " + token.generateToken(user);
    }
}







