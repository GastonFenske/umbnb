package com.um.repositories;
import com.um.models.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {
}

