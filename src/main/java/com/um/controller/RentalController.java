package com.um.controller;

import com.um.models.House;
import com.um.models.Rental;
import com.um.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    
    @Autowired
    private RentalRepository rentalRepository;


    @GetMapping
    public Page<Rental> getAllRentals(Integer page, Integer size) {
        return rentalRepository.findAll(PageRequest.of(page, size));
    }
    @PostMapping
    public void addRental(@RequestBody Rental rental) {
        rentalRepository.save(rental);

    // @RequestMapping("/rentals")
    // public List<Object> getRentals(){
    //     return (List<Object>) rentalRepository.getAll(Rental.class);
    // }

    @PostMapping("/rentals")
    public void createRental(@RequestBody Rental rental){
        rentalRepository.create(rental);
    }

    @RequestMapping("/rental/{id}")
    public Rental getRental(@PathVariable Long id){
        return (Rental) rentalRepository.getOne(Rental.class, id);

    }

    @DeleteMapping("/rental/{id}")
    public void deleteRental(@PathVariable Long id){
        Rental rental = (Rental) rentalRepository.getOne(Rental.class, id);
        rentalRepository.deleteOne(rental);
    }

    @PutMapping("/rental/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody Rental rental){
        rental.setId(id);
        rentalRepository.update(rental);
    }

}
