package com.um.controller;

import com.um.auth.UserAuth;
import com.um.models.User;
import com.um.repositories.UserRepository;
import com.um.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAuth userAuth;

    @Autowired
    private UserRepository userRepository;

    public Page<User> getAllUsers(Integer page, Integer size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping(value="/{id}") 
    public Object getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public ResponseUtil addUser(@RequestBody User user) {
        System.out.println("ENTRA ACAAA");
        return userAuth.verifyEmailDuplicated(user);
    }
    @PutMapping
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }
    @DeleteMapping(value="/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}