

package com.example.demo.repositories;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.models.Casa;

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
        Casa casa = entityManager.find(Casa.class, id);
        return casa;
    }

    @Override
    public List<Object> getAll(String model){
        String query = String.format("FROM Casa");
        List<Object> casas = entityManager.createQuery(query).getResultList();
        // List<Casa> casas = entityManager.
        // return (List<Casa>) entityManager.createQuery(query).getResultList();
        return casas;
    }

    @Override
    public void create(Object model){
        Casa casa = (Casa) model;
        entityManager.merge(casa);
    }

}