


package com.um.repositories;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.um.models.House;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
@Transactional
public class HouseRepository implements BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Object getOne(String model, Long id){
        // String query = String.format("FROM Usuario WHERE id = %2d", id);
        // return entityManager.createQuery(query).getSingleResult();
        House house = entityManager.find(House.class, id);
        return house;
    }

    @Override
    public List<Object> getAll(String model){
        String query = String.format("FROM House");
        List<Object> houses = entityManager.createQuery(query).getResultList();
        // List<House> houses = entityManager.
        // return (List<House>) entityManager.createQuery(query).getResultList();
        return houses;
    }

    @Override
    public void create(Object model){
        House house = (House) model;
        entityManager.merge(house);
    }

}