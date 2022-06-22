package com.um.controller;

import com.um.models.House;
import com.um.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController {


    @Autowired
    private HouseRepository houseRepository;


    @RequestMapping("/houses")
    public List<Object> getHouses(){
        return (List<Object>) houseRepository.getAll(House.class);
    }

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
        House current_house = (House) houseRepository.getOne(House.class, id);
        current_house.setName(house.getName());
        current_house.setAddress(house.getAddress());
        current_house.setPrice(house.getPrice());
        current_house.setPersonsNumber(house.getPersonsNumber());
        current_house.setRoomsNumber(house.getRoomsNumber());
        current_house.setReview(house.getReview());
        current_house.setOwner(house.getOwner());

        houseRepository.update(current_house);
    }


}
