package com.um.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.um.models.House;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Transactional
public class HouseRepository implements BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Object getOne(Object model, Long id){

        House house = entityManager.find(House.class, id);
        return house;
    }

    @Override
    public List<Object> getAll(Object model){
        String query = String.format("FROM House");
        List<Object> houses = entityManager.createQuery(query).getResultList();
        return houses;
    }

    @Override
    public void create(Object model){
        House house = (House) model;
        entityManager.merge(house);
    }

    @Override
    public void deleteOne(Object model){
        House house = (House) model;
        entityManager.remove(house);
    }

    @Override
    public void update(Object model){
        House house = (House) model;
        entityManager.merge(house);
    }

}