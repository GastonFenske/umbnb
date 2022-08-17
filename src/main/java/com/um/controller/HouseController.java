package com.um.controller;

import com.um.models.House;
import com.um.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseRepository houseRepository;

    @GetMapping
    public Page<House> getAllHouses(Integer page, Integer size) {
        return houseRepository.findAll(PageRequest.of(page, size));
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