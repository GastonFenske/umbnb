package com.um.controller;
import com.um.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.um.auth.UserAuth;

@RestController
public class AuthController {

    @Autowired
    private UserAuth userAuth;

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        User current_user = userAuth.userLogged(user);
        return userAuth.createToken(current_user);
    }

}