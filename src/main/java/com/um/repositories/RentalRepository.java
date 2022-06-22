package com.um.repositories;
import com.um.models.Rental;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RentalRepository implements BaseRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Object getOne(Object model, Long id){

        Rental rental = entityManager.find(Rental.class, id);
        return rental;
    }

    @Override
    public List<Object> getAll(Object model){
        String query = String.format("FROM Rental");
        List<Object> rentals = entityManager.createQuery(query).getResultList();
        return rentals;
    }

    @Override
    public void create(Object model){
        Rental rental = (Rental) model;
        entityManager.merge(rental);
    }

    @Override
    public void deleteOne(Object model){
        Rental rental = (Rental) model;
        entityManager.remove(rental);
    }

    @Override
    public void update(Object model){
        Rental rental = (Rental) model;
        entityManager.merge(rental);
    }

}
