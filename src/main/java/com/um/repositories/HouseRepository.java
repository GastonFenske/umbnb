package com.um.repositories;

import com.um.models.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    @Query("select h from House h where h.id = ?1")
    House getHouseById(Long id);

    @Query("select h from House h where h.province = ?1")
    List<House> getAllHousesByProvince(String province);


    @Query("select h from House h where h.city = ?1")
    List<House> getAllHousesByCity(String city);


    @Query("select h from House h where h.owner.id = ?1")
    List<House> getAllHousesByOwnerId(Long id);









}

