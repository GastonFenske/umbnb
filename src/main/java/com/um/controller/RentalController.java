package com.um.controller;

import com.um.auth.HostRequired;
import com.um.models.Rental;
import com.um.repositories.RentalRepository;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;

    // @HostRequired
    // @GetMapping
    // public Object getRentals(@RequestHeader("Authorization") String token, Integer page, Integer size){
    //     return (List<Rental>) rentalRepository.findAll();
    // }

    @HostRequired
    @GetMapping
    public Object getAllRentals(@RequestHeader("Authorization") String token, Integer page, Integer size) {
        return (Page<Rental>) rentalRepository.findAll(PageRequest.of(page, size));
    }

    // @HostRequired
    // @GetMapping
    // public Page<Rental> getAllRentals(@RequestHeader("Authorization") String token, Integer page, Integer size) {
    //     return rentalRepository.findAll(PageRequest.of(page, size));
    // }

    @PostMapping
    public void addRental(@RequestBody Rental rental) {
        rentalRepository.save(rental);
    }
    @PutMapping
    public void updateRental(@RequestBody Rental rental) {
        rentalRepository.save(rental);
    }
    @DeleteMapping(value="/deleteRental/{id}")
    public ResponseEntity<String> deleteRental(@PathVariable("id") Long id) {
        rentalRepository.deleteById(id);
        return ResponseEntity.ok("Rental deleted successfully");
    }
}