package com.um.repositories;

import com.um.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // @Query("select u from User u where u.email = ?1 and u.password = ?2")
    // User findByEmailAndPassword(String email, String password);

    @Query("select u from User u where u.email = ?1")
    User getUserByEmail(String email);

}

