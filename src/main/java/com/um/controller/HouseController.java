package com.um.controller;

import com.um.models.House;
import com.um.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;

    @GetMapping
    public List<House> getAllHouses() {
        return (List<House>) houseRepository.findAll();
    }

    @PostMapping
    public void addHouse(@RequestBody House house) {
        houseRepository.save(house);
    }
    @PutMapping
    public void updateHouse(@RequestBody House house) {
        houseRepository.save(house);
    }
    @DeleteMapping(value="/deleteHouse/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable("id") Long id) {
        houseRepository.deleteById(id);
        return ResponseEntity.ok("House deleted successfully");
    }
}
