package com.um.controller;

import com.um.models.Rental;
import com.um.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {
    
    @Autowired
    private RentalRepository rentalRepository;


    @RequestMapping("/rentals")
    public List<Object> getRentals(){
        return (List<Object>) rentalRepository.getAll(Rental.class);
    }

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