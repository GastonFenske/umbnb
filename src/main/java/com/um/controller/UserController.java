package com.um.controller;

import com.um.models.Rental;
import com.um.models.User;
import com.um.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Page<User> getAllUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size));

    // @RequestMapping("/users")
    // public List<Object> getUsers(){
    //     return (List<Object>) userRepository.getAll(User.class);
    // }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userRepository.create(user);
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return (User) userRepository.getOne(User.class, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = (User) userRepository.getOne(User.class, id);
        userRepository.deleteOne(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        userRepository.update(user);
    }


}

