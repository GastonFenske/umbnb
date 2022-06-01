package com.um.controller;

import com.um.models.Rental;
import com.um.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    private RentalRepository rentalRepository;

    @GetMapping
    public List<Rental> getAllRentals() {
        return (List<Rental>) rentalRepository.findAll();
    }

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
