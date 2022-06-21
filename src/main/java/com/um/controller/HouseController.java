package com.um.controller;

import com.um.models.House;
import com.um.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {


    @Autowired
    private HouseRepository houseRepository;


    @RequestMapping("/houses")
    public List<Object> getHouses(){
        return (List<Object>) houseRepository.getAll("House");
    }

    @PostMapping("/houses")
    public void createCasa(@RequestBody House house){
        houseRepository.create(house);
    }

    @RequestMapping("/house/{id}")
    public House getHouse(@PathVariable Long id){
        return (House) houseRepository.getOne("House", id);
    }



}
