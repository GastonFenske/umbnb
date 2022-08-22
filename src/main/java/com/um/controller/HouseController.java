package com.um.controller;

import com.um.models.House;
import com.um.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {


    @Autowired
    private HouseRepository houseRepository;


    @GetMapping
    public Page<House> getAllHouses(Integer page, Integer size) {
        return houseRepository.findAll(PageRequest.of(page, size));


    // @RequestMapping("/houses")
    // public List<Object> getHouses(){
    //     return (List<Object>) houseRepository.getAll(House.class);
    // }

    @PostMapping("/houses")
    public void createHouse(@RequestBody House house){
        houseRepository.create(house);

    }

    @RequestMapping("/house/{id}")
    public House getHouse(@PathVariable Long id){
        return (House) houseRepository.getOne(House.class, id);
    }

    @DeleteMapping("/house/{id}")
    public void deleteHouse(@PathVariable Long id){
        House house = (House) houseRepository.getOne(House.class, id);
        houseRepository.deleteOne(house);
    }

    @PutMapping("/house/{id}")
    public void updateHouse(@PathVariable Long id, @RequestBody House house){
        house.setId(id);
        houseRepository.update(house);

    }


}
